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

	public double getMaxAttrib(Project.Attribute attr) {return 0;}
	public double getMinAttrib(Project.Attribute attr) {return 0;}
	
}
