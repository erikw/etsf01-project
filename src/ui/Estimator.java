package ui;

import model.*;
import io.*;
import java.util.*;
import java.io.*;

import org.ini4j.Ini;


public class Estimator {
	private ProjectDB db;
	private Map<String, String[]> attribs;

	public static void main (String [] args)
	{
		Locale.setDefault(new Locale("en", "US")); // Use a sane locale.

		System.out.println("");
		System.out.println(" dP\"\"b8 88\"\"Yb 888888    db    888888 888888 8888b.      88\"\"Yb Yb  dP");
		System.out.println("dP   '\" 88__dP 88__     dPYb     88   88__    8I  Yb     88__dP  YbdP");
		System.out.println("Yb      88\"Yb  88\"\"    dP__Yb    88   88\"\"    8I  dY     88\"\"Yb   8P");
		System.out.println(" YboodP 88  Yb 888888 dP\"\"\"\"Yb   88   888888 8888Y\"      88oodP  dP");
		System.out.println("");
		System.out.println("888888    db    88\"\"Yb 8888b.      .dP\"Y8  dP\"Yb  88   88    db    8888b.");
		System.out.println("  88     dPYb   88__dP  8I  Yb     'Ybo.\" dP   Yb 88   88   dPYb    8I  Yb");
		System.out.println("  88    dP__Yb  88\"Yb   8I  dY     o.'Y8b Yb b dP Y8   8P  dP__Yb   8I  dY");
		System.out.println("  88   dP\"\"\"\"Yb 88  Yb 8888Y\"      8bodP'  '\"YoYo 'YbodP' dP\"\"\"\"Yb 8888Y");
		System.out.println("");
		System.out.println("Press CTRL+C to terminate program");
		System.out.println("");
		if (args.length != 1) {
			System.err.println("Missing file name.");
			System.exit(1);
		} else {
			Estimator est = new Estimator(args[0]);
			est.getParams();
			System.exit(0);
		}
	}

	public Estimator(String fileName) {
		try {
			db = new CocoMoDB();
			this.getUserAttributes();
			Parser parser = new Parser(db);
			parser.parse(fileName);
			attribs = new LinkedHashMap<String, String[]>();
			attribs.put("RELY", new String[] {"Low", "Nominal","High","Very_High"});
			attribs.put("DATA", new String[] {"Low","Nominal","High","Very_High"});
			attribs.put("CPLX", new String[] {"Low","Nominal","High","Very_High","Extra_High"});
			attribs.put("TIME", new String[] {"Nominal","High","Very_High","Extra_High"});
			attribs.put("STOR", new String[] {"Nominal","High","Very_High","Extra_High"});
			attribs.put("VIRT", new String[] {"Low","Nominal","High","Very_High"});
			attribs.put("TURN", new String[] {"Low","Nominal","High"});
			attribs.put("ACAP", new String[] {"Nominal","High","Very_High"});
			attribs.put("AEXP", new String[] {"Nominal","High","Very_High"});
			attribs.put("PCAP", new String[] {"Nominal","High","Very_High"});
			attribs.put("VEXP", new String[] {"Low","Nominal","High"});
			attribs.put("LEXP", new String[] {"Very_Low","Low","Nominal","High"});
			attribs.put("MODP", new String[] {"Low","Nominal","High","Very_High"});
			attribs.put("TOOL", new String[] {"Very_Low","Low","Nominal","High","Very_High"});
			attribs.put("SCED", new String[] {"Low","Nominal","High"});
			attribs.put("LOC", new String[0]);
			if(Project.containsAttribute(Project.Attribute.USER1)){
				if(Project.isNumericalAttribute(Project.Attribute.USER1)){
					attribs.put("USER1", new String[0]);
				} else {
					attribs.put("USER1", new String[] {"Very_Low","Low","Nominal","High","Very_High", "Extra_High"});
				}
			}
			if(Project.containsAttribute(Project.Attribute.USER2)){
				if(Project.isNumericalAttribute(Project.Attribute.USER2)){
					attribs.put("USER2", new String[0]);
				} else {
					attribs.put("USER2", new String[] {"Very_Low","Low","Nominal","High","Very_High", "Extra_High"});
				}
			}
			if(Project.containsAttribute(Project.Attribute.USER3)){
				if(Project.isNumericalAttribute(Project.Attribute.USER3)){
					attribs.put("USER3", new String[0]);
				} else {
					attribs.put("USER3", new String[] {"Very_Low","Low","Nominal","High","Very_High", "Extra_High"});
				}
			}
		} catch(IOException e){
			System.err.println("File not found.");
			System.exit(1);
		}
	}

	private void getAndAddUserAttr(Ini newAttribs, Project.Attribute attr, String sec){
		String type = newAttribs.get(sec, "type");
		if(type == null){
			return;
		}
		if(type.equals("num")){
			Project.addUserAttribute(attr, new HashMap<Project.AttributeValue, Double>());
		} else if(type.equals("cat")) {
			double vl = newAttribs.get(sec, "very_low", double.class);
			double l = newAttribs.get(sec, "low", double.class);
			double n = newAttribs.get(sec, "nominal", double.class);
			double h = newAttribs.get(sec, "high", double.class);
			double vh = newAttribs.get(sec, "very_high", double.class);
			double eh = newAttribs.get(sec, "extra_high", double.class);
			HashMap<Project.AttributeValue, Double> useratts = new HashMap<Project.AttributeValue, Double>();
			if(vl > 0.0){
				useratts.put(Project.AttributeValue.VERY_LOW, vl);
			}
			if(l > 0.0){
				useratts.put(Project.AttributeValue.LOW, l);
			}
			if(n > 0.0){
				useratts.put(Project.AttributeValue.NOMINAL, n);
			}
			if(h > 0.0){
				useratts.put(Project.AttributeValue.HIGH, h);
			}
			if(vh > 0.0){
				useratts.put(Project.AttributeValue.VERY_HIGH, vh);
			}
			if(eh > 0.0){
				useratts.put(Project.AttributeValue.EXTRA_HIGH, eh);
			}
			Project.addUserAttribute(attr, useratts);
		} else {System.out.println("ERROR incorrect type of user attribute: " + sec);}

	}
	
	public void getUserAttributes(){
		try {
			Ini newAttribs = new Ini(new File("extra.ini"));
			getAndAddUserAttr(newAttribs, Project.Attribute.USER1, "user1");
			getAndAddUserAttr(newAttribs, Project.Attribute.USER2, "user2");
			getAndAddUserAttr(newAttribs, Project.Attribute.USER3, "user3");
		} catch (IOException e) {
			System.out.println("Could not find any extra attributes. Only using standard attributes.");
		}
	}

	public void getParams() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> userAttribs = new ArrayList<String>();
		for (String key : attribs.keySet()) {
			System.out.println(key + ", choose a number:");
			String[] values = attribs.get(key);
			printVal(values);
			boolean correct = false;
			int number = 0;
			double numericalValue = 0.0;
			while (!correct) {
				System.out.print("> ");
				// Must check if double first!!
				if (sc.hasNextDouble() && values.length == 0) {
					numericalValue = sc.nextDouble();
					userAttribs.add(""+numericalValue);
					correct = true;
				} else if (sc.hasNextInt()) {
					number = sc.nextInt();
					if (number >= 0 && number < values.length) {
						correct = true;
						userAttribs.add(values[number]);
					} else {
						sc.nextLine(); // Skip bad line.
						System.err.println("Bad number, try again.");
					}
				} else {
					sc.nextLine(); // Skip bad line.
					System.err.println("Type number.");
				}
			}
		}
		if(userAttribs.size() < 17){
			userAttribs.add("0.0");
		} else {
			userAttribs.add(16, "0.0");
		}

		double threshold;
		do {
			System.out.println("Threshold, enter number in range [0,1]:");
			threshold = getDoubleInput(sc, new ArrayList<String>());	
		} while (threshold < 0 || threshold > 1);
		db.setThreshold(threshold); //Skickar in en tom ArrayList för att inte Threshold ska läggas till userAttributes.

		Project inputProject = new Project(userAttribs);

		ArrayList<Result> similarProjects = (ArrayList<Result>) db.similarProjects(inputProject);
		if(similarProjects.size() == 0){
	
			System.err.println("\u001B[31m\u001B[1mWARNING! No projects within given threshold\u001B[0m");
		} else {
			System.out.println("Found " + similarProjects.size() + " similar project(s). ");
		}

		double estimatePM = inputProject.calculateEffort(similarProjects);
		System.out.printf("Time estimation is: \n" );
		System.out.printf("Person Hours: %.2f\n", db.PMonthsToPHours(estimatePM));
		System.out.printf("Person Days: %.2f\n", db.PMonthsToPDays(estimatePM));
		System.out.printf("Person Months: %.2f\n", estimatePM);
		System.out.printf("Person Years: %.2f\n", db.PMonthsToPYears(estimatePM));

	}

	private void printVal(String[] values) {
		for (int i = 0; i < values.length; ++i) {
			System.out.println(i  + ". " + values[i]);
			}
		}
	
	private double getDoubleInput(Scanner sc, ArrayList<String> userAttribs){
		//Scanner sc = new Scanner(System.in);
		boolean correct = false;
		double number = 0.0;
		while (!correct) {
			System.out.print("> ");
			if (sc.hasNextDouble()) {
				correct = true;
				number = sc.nextDouble();
				userAttribs.add(String.valueOf(number));
			} else {
				sc.nextLine(); // Skip bad line.
				System.err.println("Bad number, try again.");
			}
		}
		return number;
	}
}
