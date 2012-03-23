package model;

import java.util.ArrayList;
import java.util.HashMap;

public class CocoMoDB implements ProjectDB  {
	private ArrayList<Project> refProjects;
	private double threshold;
	private double pred;
	private double[][] values = { { 0.49, 0.60, 0.83, 1.00, 1.33, 1.91, 2.72 }, { 0, 0, 0.95, 1.00, 1.07, 1.15, 1.24 },  { 0, 0, 0.87, 1.00, 1.29, 1.81, 2.61 }, { 2.12, 1.62, 1.26, 1.00, 0.83, 0.63, 0.50 }, { 1.59, 1.33, 1.12, 1.00, 0.87, 0.74, 0.62 }, { 1.43, 1.30, 1.10, 1.00, 0.87, 0.73, 0.62 }, { 0, 1.43, 1.14, 1.00, 1.00, 1.00, 0 } }; 
	private HashMap<String,Integer> attributes = new HashMap<String, Integer>(); 

	
	public CocoMoDB(){
		refProjects = new ArrayList<Project>();
		attributes.put("Extra_Low", 0);
		attributes.put("Very_Low", 1);
		attributes.put("Low", 2);
		attributes.put("Nominal", 3);
		attributes.put("High", 4);
		attributes.put("Very_High", 5);
		attributes.put("Extra_High", 6);
		
	
	}
	public void addProject(Project proj){
		refProjects.add(proj);
	}
	public ArrayList<Project> getSimilar(Project proj){
		return refProjects;
	}
	public void setThreshold(double newThreshold){
		threshold = newThreshold;
	}
	private double eucLength(Project source){
		return 0.0;
	}

}
