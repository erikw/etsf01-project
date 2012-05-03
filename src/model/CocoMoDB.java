package model;

import java.util.*;

public class CocoMoDB implements ProjectDB  {
	private ArrayList<Project> refProjects;

	private double threshold;

	private double pred;

	private HashMap<String,Integer> attributes = new HashMap<String, Integer>(); 
	
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

	// remove
	public ArrayList<Project> getSimilar(Project proj){
		return refProjects;
	}

	public void setThreshold(double newThreshold) {
		threshold = newThreshold;
	}

	public double getThreshold() {
		return threshold;
	}

/*
	private double eucLength(Project source){
		//for(Double d : atrToValue(source.getList())){
			//// do calc lolz
		//}
		return 0.0;
	}
*/

	public List<Result> similarProjects(Project inputProject) {
		//LinkedList<Project> projects = new LinkedList<Project>();
		ArrayList<Result> projects = new ArrayList<Result>();
		double tmpSim;
		for (Project p : refProjects) {
			if ((tmpSim = p.calculateSimilarity(inputProject, this)) >= threshold) {
				projects.add( new Result(tmpSim, p));
			}
		}
		return projects;
	}

	// Returns person months.
	public double getEstimate(Map<Double,Project> similarProjects) {
		return 0;
	}

	public double PMonthsToPHours(double pm) {
		return pm * 168;
	}

	public double PMonthsToPDays(double pm) {
		return pm * 21;
	}

	public double PMonthsToPYears(double pm) {
		return pm / 12;
	}

/*
	private ArrayList<Double> atrToValue(ArrayList<String> toBeMapped){
		ArrayList<Double> atr = new ArrayList<Double>();
		for(int i = 0; i < toBeMapped.size()-2; i++ ){
			atr.add(values[i][attributes.get(toBeMapped.get(i))]);
		}
		return atr;
	}
*/

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
