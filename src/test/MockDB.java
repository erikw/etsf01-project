package test;

import model.*;
import java.util.*;

public class MockDB implements ProjectDB {

	public void addProject(Project proj) {
		;
	}

	public ArrayList<Project> getSimilar(Project proj) {
		return null;
	}

	public void setThreshold(double newThreshold) {
	}

	public Map<Double, Project> similarProjects(Project inputProject) {
		return new HashMap<Double, Project>();
	}

	public double getMaxAttrib(Project.Attribute attr) {return 0;}
	public double getMinAttrib(Project.Attribute attr) {return 0;}
	public double PMonthsToPHours(double pm) {return 0;}
	public double PMonthsToPDays(double pm) {return 0;}
	public double PMonthsToPYears(double pm) {return 0;}
	public double getThreshold() { return 0;}
	public double getEstimate(Map<Double, Project> similarProjects) {
		return 0.0;
	}
}
