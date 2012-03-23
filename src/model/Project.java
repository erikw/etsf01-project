package model;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private List<String> attributes;

	public enum Attribute { RELY, DATA, CPLX, TIME, STOR, VIRT, TURN, ACAP, AEXP, PCAP,
					VEXP, LEXP, MODP, TOOL, SCED, LOC, ACT_EFFORT}

	public Project(List<String> attributes){
		this.attributes = attributes;
	}
		
	private void setAttribute(Attribute attr, String value){
	
	}

	public double calculateSimilarity(Project rhs){
		return 0.0;
	}
	
	public ArrayList<String> getList(){
		return (ArrayList<String>) attributes;
	}

	/* see lecture 1 page 9. */
	public double calculateEffort(List<Project> similarProjects){
		return 0.0;
	}
}
