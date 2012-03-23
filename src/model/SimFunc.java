package model;


public abstract class SimFunc {
protected ProjectDB db;
public SimFunc(ProjectDB db){
	this.db = db;
}

public List<Project> simularProj(Project proj);
private double compare(Project proj);

}
