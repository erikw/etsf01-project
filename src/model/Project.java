package model;

import java.util.List;

public class Project {

	public enum Attribute { RELY, DATA, CPLX, TIME, STOR, VIRT, TURN, ACAP, PCAP,
					VEXP, LEXP, MODP, TOOL, SCED, LOC, ACT_EFFORT}

	public Project(List<String> attributes){
	}
		
	private void setAttribute(Attribute attr, String value){
	
	}

	public double calculateSimilarity(Project rhs){
		return 0.0;
	}
}
