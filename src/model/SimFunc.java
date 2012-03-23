package model;


public abstract class SimFunc {
protected ProjectDB db;
protected double threshold;
protected double pred;
public SimFunc(ProjectDB db){
	this.db = db;
	threshold = 0;
	pred = 0;
}

public List<Project> simularProj(Project proj);
public double predProj(){
	return pred;
}
private double compare(Project proj);
public void setThreshold(double newThreshold){
	threshold = newThreshold;
}

}
