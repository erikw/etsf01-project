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
			db = new CocoMoDB();
			Parser parser = new Parser(db);
			parser.parse(fileName);
			//attribs = new HashMap<String, String[]>();
			attribs = new LinkedHashMap<String, String[]>();
			attribs.put("RELY", new String[] {"Nominal","Very_High","High","Low"});
			attribs.put("DATA", new String[] {"High","Low","Nominal","Very_High"});
			attribs.put("CPLX", new String[] {"Very_High","High","Nominal","Extra_High","Low"});
			attribs.put("TIME", new String[] {"Nominal","Very_High","High","Extra_High"});
			attribs.put("STOR", new String[] {"Nominal","Very_High","High","Extra_High"});
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

	}

	public void getParams() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> userAttribs = new ArrayList<String>();
		for (String key : attribs.keySet()) {
			System.out.println(key + ", choose number:");
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
				}
			}
			userAttribs.add(values[number]);
		}
		System.out.println("LOC, enter number:");
		boolean correct = false;
		while (!correct) {
			System.out.print("> ");
			if (sc.hasNextInt()) {
				correct = true;
				int number = sc.nextInt();
				userAttribs.add(String.valueOf(number));
			} else {
				System.err.println("Bad number, try again.");
			}
		}

		System.out.println("ACT_EFFORT, enter number:");
		correct = false;
		while (!correct) {
			System.out.print("> ");
			if (sc.hasNextInt()) {
				correct = true;
				int number = sc.nextInt(); // TODO is a double?
				userAttribs.add(String.valueOf(number));
			} else {
				System.err.println("Bad number, try again.");
			}
		}



		for (String str : userAttribs) {
			System.out.println("user attrib is: " + str);
		}
		Project inputProject = new Project(userAttribs);


		// TODO user inputProject in  algorithm.
		System.out.println("Time estimation is:....");
	}

	private void printVal(String[] values) {
		for (int i = 0; i < values.length; ++i) {
			System.out.println(i  + ". " + values[i]);
		}
	}
	


	//program loaded
	//enter Att c [high, medium, low] :
	//> tal
	//enter Att b:
	//> tal
	//enter Att b:
	//> tal
	//enter Att b:
	//Estimate is: 3454
	//> 

	public int getEstimate(String[] params) {
		return 0;

	}
}
