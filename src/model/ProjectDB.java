package model;

import java.util.ArrayList;

public interface ProjectDB {

	void addProject(Project proj);
	ArrayList<Project> getSimilar(Project proj);

}
