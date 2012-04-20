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
			attribs.put("RELY", new String[] {"Nominal","Very_High","High","Low"});
			attribs.put("DATA", new String[] {"High","Low","Nominal","Very_High"});
			attribs.put("CPLX", new String[] {"Very_High","High","Nominal","Extra_High","Low"});
			attribs.put("TIME", new String[] {"Nominal","Very_High","High","Extra_High"});
			attribs.put("STOR", new String[] {"Nominal","Very_High","High","Extra_High"});
			attribs.put("VIRT", new String[] {"Low","Nominal","High","Very_High"});
			attribs.put("TURN", new String[] {"Nominal","High","Low"});
			attribs.put("ACAP", new String[] {"High","Very_High","Nominal"});
			attribs.put("AEXP", new String[] {"Nominal","Very_High","High"});
			attribs.put("PCAP", new String[] {"Very_High","High","Nominal"});
			attribs.put("VEXP", new String[] {"Low","Nominal","High"});
			attribs.put("LEXP", new String[] {"Nominal","High","Very_Low","Low"});
			attribs.put("MODP", new String[] {"High","Nominal","Very_High","Low"});
			attribs.put("TOOL", new String[] {"Nominal","High","Very_High","Very_Low","Low"});
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
						System.err.println("Bad number, try again.");
					}
				} else {
					System.err.println("Type number.");
					sc = new Scanner(System.in);
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
			System.out.println("Threshold, enter number(0-100):");
			threshold = getDoubleInput(sc, new ArrayList<String>());	
		} while (threshold < 0 || threshold > 100);
		db.setThreshold(threshold/100.0); //Skickar in en tom ArrayList för att inte Threshold ska läggas till userAttributes.

		for (String str : userAttribs) {
			System.out.println("User attribute is: " + str);
		}
		Project inputProject = new Project(userAttribs);

		List<Project> similarProjects = db.similarProjects(inputProject);
		System.out.println("Found " + similarProjects.size() + " similar project(s). ");

		double estimatePM = db.getEstimate(similarProjects);
		System.out.println("Time estimation is: " );
		System.out.println("Person Hour: " + db.PMonthsToPHours(estimatePM));
		System.out.println("Person Days: " + db.PMonthsToPDays(estimatePM));
		System.out.println("Person Months: " + estimatePM);
		System.out.println("Person Years: " + db.PMonthsToPYears(estimatePM));

		// TODO Informera användaren om  det riktiga värdet är lägre än threshold
	}

	private void printVal(String[] values) {
		for (int i = 0; i < values.length; ++i) {
			System.out.println(i  + ". " + values[i]);
		}
	}


	
	private double getDoubleInput(Scanner sc, ArrayList<String> userAttribs){
		boolean correct = false;
		double number = 0.0;
		while (!correct) {
			System.out.print("> ");
			if (sc.hasNextDouble()) {
				correct = true;
				number = sc.nextDouble();
				userAttribs.add(String.valueOf(number));
			} else {
				System.err.println("Bad number, try again.");
				sc = new Scanner(System.in);
			}
		}
		return number;
	}

	public int getEstimate(String[] params) {
		return 0;

	}
}
