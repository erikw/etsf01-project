package model;

import java.util.*;

public class Project {
	private Map<Attribute, Double> attribCategorial;
	private Map<Attribute, Double> attribNummerical;

	public enum Attribute { RELY, DATA, CPLX, TIME, STOR, VIRT, TURN, ACAP, AEXP, PCAP,
					VEXP, LEXP, MODP, TOOL, SCED, LOC, ACT_EFFORT}

	public Project(List<String> attributes){
		attribCategorial = new HashMap<Attribute, Double>();
		attribNummerical = new HashMap<Attribute, Double>();
		Iterator<String> iter = attributes.iterator();
		for (Attribute att : EnumSet.range(Attribute.RELY, Attribute.SCED)) {
			try {
				attribCategorial.put(att, Double.parseDouble(iter.next()));
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}
		}

		for (Attribute att : EnumSet.range(Attribute.LOC, Attribute.ACT_EFFORT)) {
			try {
				attribNummerical.put(att, Double.parseDouble(iter.next()));
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}
		}
	}
		
	private void setAttribute(Attribute attr, String value){
	
	}

	public double getAttribute(Attribute attr){
		if (attribCategorial.containsKey(attr)) {
			return attribCategorial.get(attr);
		} else {
			return attribNummerical.get(attr);
		}
	}

	public double calculateSimilarity(Project rhs, ProjectDB db) {
		double distance = 0.0;
		for (Attribute a : attribCategorial.keySet()) {
			if (attribCategorial.get(a) != rhs.getAttribute(a)) {
				distance += 1;
			}
		}

		for (Attribute a : attribNummerical.keySet()) {
			distance += Math.pow((attribNummerical.get(a) - rhs.getAttribute(a)) / (db.getMaxAttrib(a) - db.getMinAttrib(a)) , 2);
		}

		double similarity = 1 - Math.sqrt(distance/(attribCategorial.size() + attribNummerical.size()));
		return similarity;
	}
	
	/* see lecture 1 page 9. */
	public double calculateEffort(List<Project> similarProjects){
		return 0.0;
	}
}
