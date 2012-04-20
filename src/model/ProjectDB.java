package model;

import java.util.ArrayList;

public interface ProjectDB {

	public void addProject(Project proj);
	public ArrayList<Project> getSimilar(Project proj);
	public void setThreshold(double newThreshold);
	public double getMaxAttrib(Project.Attribute attr);
	public double getMinAttrib(Project.Attribute attr);

}
