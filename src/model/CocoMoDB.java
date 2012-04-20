package model;

import java.util.ArrayList;
import java.util.HashMap;

public class CocoMoDB implements ProjectDB  {
	private ArrayList<Project> refProjects;

	private double threshold;

	private double pred;

	private HashMap<String,Integer> attributes = new HashMap<String, Integer>(); 

	private double[][] values = {
		{ 0.75, 0.88, 1.00, 1.15, 1.40, 0   },
		{ 0,    0.94, 1.00, 1.08, 1.16, 0   },
		{ 0.70, 0.85, 1.00, 1.15, 1.30, 1.65}, 
		{ 0,    0,    1.00, 1.11, 1.30, 1.66},
		{ 0,    0,    1.00, 1.06, 1.21, 1.56},
		{ 0,    0.87, 1.00, 1.15, 1.30, 0   },
		{ 0,    0.87, 1.00, 1.07, 1.15, 0   }, 
		{ 1.46, 1.19, 1.00, 0.86, 0.71, 0   },
		{ 1.29, 1.13, 1.00, 0.91, 0.82, 0   },
		{ 1.42, 1.17, 1.00, 0.86, 0.70, 0   },
		{ 1.21, 1.10, 1.00, 0.90, 0,    0   }, 
		{ 1.14, 1.07, 1.00, 0.95, 0,    0   },
		{ 1.24, 1.10, 1.00, 0.91, 0.82, 0   },
		{ 1.24, 1.10, 1.00, 0.91, 0.83, 0   },
		{ 1.23, 1.08, 1.00, 1.04, 1.10, 0   } }; 

	
	public CocoMoDB(){
		refProjects = new ArrayList<Project>();
		attributes.put("Very_Low", 0);
		attributes.put("Low", 1);
		attributes.put("Nominal", 2);
		attributes.put("High", 3);
		attributes.put("Very_High", 4);
		attributes.put("Extra_High", 5);
	}

	public void addProject(Project proj){
		refProjects.add(proj);
	}

	public ArrayList<Project> getSimilar(Project proj){
		return refProjects;
	}

	public void setThreshold(double newThreshold) {
		threshold = newThreshold;
	}

	public double getThreshold() {
		return threshold;
	}

	private double eucLength(Project source){
		//for(Double d : atrToValue(source.getList())){
			//// do calc lolz
		//}
		return 0.0;
	}

	private ArrayList<Double> atrToValue(ArrayList<String> toBeMapped){
		ArrayList<Double> atr = new ArrayList<Double>();
		for(int i = 0; i < toBeMapped.size()-2; i++ ){
			atr.add(values[i][attributes.get(toBeMapped.get(i))]);
		}
		return atr;
	}


	public double getMaxAttrib(Project.Attribute attr) {
		double max = 0;
		double value;
		for (Project p : refProjects) {
			value = p.getAttribute(attr);
			if (value > max) {
				max = value;
			}
		}
		return max;
	}

	public double getMinAttrib(Project.Attribute attr) {
		double min = Double.MAX_VALUE;
		double value;
		for (Project p : refProjects) {
			value = p.getAttribute(attr);
			if (value < min) {
				min = value;
			}
		}
		return min;
	}

}
