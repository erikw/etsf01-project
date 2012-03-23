package model;

import java.util.ArrayList;

public interface ProjectDB {

	public void addProject(Project proj);
	public ArrayList<Project> getSimilar(Project proj);

}
