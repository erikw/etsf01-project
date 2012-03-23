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
			attribs = new HashMap<String, String[]>();
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
			attribs.put("LOC",  new String[] {"numeric"});
			attribs.put("ACT_EFFORT", new String[] {"numeric"});

	}

	public void getParams() {
		Scanner sc = new Scanner(System.in);
		System.out.println("RELY {Nominal,Very_High,High,Low}");
		
		System.out.println("DATA {High,Low,Nominal,Very_High}");
		System.out.println("CPLX {Very_High,High,Nominal,Extra_High,Low");
		System.out.println("TIME {Nominal,Very_High,High,Extra_High}");
		System.out.println("STOR {Nominal,Very_High,High,Extra_High}");
		System.out.println("TURN {Nominal,High,Low}");
		System.out.println("ACAP {High,Very_High,Nominal}");
		System.out.println("AEXP {Nominal,Very_High,High}");
		System.out.println("PCAP {Very_High,High,Nominal}");
		System.out.println("VEXP {Low,Nominal,High}");
		System.out.println("LEXP {Nominal,High,Very_Low,Low}");
		System.out.println("MODP {High,Nominal,Very_High,Low}");
		System.out.println("TOOL {Nominal,High,Very_High,Very_Low,Low}");
		System.out.println("SCED {Low,Nominal,High}");
		System.out.println("LOC {numeric}");
		System.out.println("ACT_EFFORT {numeric}");
		//Project inputProject = new Project();
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
