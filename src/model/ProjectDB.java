package model;

import java.util.*;

public interface ProjectDB {

	public void addProject(Project proj);
	public ArrayList<Project> getSimilar(Project proj);
	public void setThreshold(double newThreshold);
	public double getThreshold();
	public double getMaxAttrib(Project.Attribute attr);
	public double getMinAttrib(Project.Attribute attr);
	public Map<Double, Project> similarProjects(Project inputProject);
	public double getEstimate(Map<Double, Project> similarProjects);

	public double PMonthsToPHours(double pm);
	public double PMonthsToPDays(double pm);
	public double PMonthsToPYears(double pm);
}
