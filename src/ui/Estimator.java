package ui;

import model.*;
import io.*;
import java.util.*;
import java.io.*;

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
			new Estimator(args[0]).getParams();
			System.exit(0);
		}
	}

	public Estimator(String fileName) {
		try {
			db = new CocoMoDB();
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
			//attribs.put("LOC",  new String[] {"numeric"});
			//attribs.put("ACT_EFFORT", new String[] {"numeric"});
		} catch(IOException e){
			e.printStackTrace();
			//System.err.println("File not found.");
			System.exit(1);
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
			while (!correct) {
				System.out.print("> ");
				if (sc.hasNextInt()) {
					number = sc.nextInt();
					if (number >= 0 && number < values.length) {
						correct = true;
					} else {
						sc.nextLine(); // Skip bad line.
						System.err.println("Bad number, try again.");
					}
				} else {
					sc.nextLine(); // Skip bad line.
					System.err.println("Type number.");
				}
			}
			userAttribs.add(values[number]);
		}
		System.out.println("LOC, enter number:");
		getDoubleInput(sc, userAttribs);
		System.out.println("ACT_EFFORT, enter number:");
		getDoubleInput(sc, userAttribs);
		double threshold;
		do {
			System.out.println("Threshold, enter number in range [0,1]:");
			threshold = getDoubleInput(sc, new ArrayList<String>());	
		} while (threshold < 0 || threshold > 1);
		db.setThreshold(threshold); //Skickar in en tom ArrayList för att inte Threshold ska läggas till userAttributes.

		for (String str : userAttribs) {
			System.out.println("User attribute is: " + str);
		}
		Project inputProject = new Project(userAttribs);

		Map<Double, Project> similarProjects = db.similarProjects(inputProject);
		if(similarProjects.size() == 0){
	
			System.err.println("\u001B[31m\u001B[1mWARNING! No projects within given threshold\u001B[0m");
		}
		else{
			System.out.println("Found " + similarProjects.size() + " similar project(s). ");
		}

		double estimatePM = inputProject.calculateEffort(similarProjects);
		System.out.printf("Time estimation is: \n" );
		System.out.printf("Person Hours: %.2f\n", db.PMonthsToPHours(estimatePM));
		System.out.printf("Person Days: %.2f\n", db.PMonthsToPDays(estimatePM));
		System.out.printf("Person Months: %.2f\n", estimatePM);
		System.out.printf("Person Years: %.2f\n", db.PMonthsToPYears(estimatePM));

		// TODO Informera användaren om  det riktiga värdet är lägre än threshold
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

	public int getEstimate(String[] params) {
		return 0;
	}

}
