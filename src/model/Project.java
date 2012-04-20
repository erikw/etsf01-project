package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.EnumSet;
import java.lang.IllegalArgumentException;

public class Project {
	private Map<Attribute, Double> attributes;
	private Map<Attribute, Double> attribCategorial;
	private Map<Attribute, Double> attribNumerical;

	public enum Attribute { RELY, DATA, CPLX, TIME, STOR, VIRT, TURN, ACAP, AEXP, PCAP,
					VEXP, LEXP, MODP, TOOL, SCED, LOC, ACT_EFFORT}

	public enum AttributeValue { VERY_LOW, LOW, NOMINAL, HIGH, VERY_HIGH, EXTRA_HIGH }

	private static HashMap<Attribute, HashMap<AttributeValue, Double>> attributeMap = new HashMap<Attribute, HashMap<AttributeValue, Double>>(); 
	
	static {
		for (Attribute attribute : Attribute.values()){
			attributeMap.put(attribute, new HashMap<AttributeValue, Double>());
		}

		attributeMap.get(Attribute.RELY).put(AttributeValue.VERY_LOW, 0.75);
		attributeMap.get(Attribute.RELY).put(AttributeValue.LOW, 0.88);
		attributeMap.get(Attribute.RELY).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.RELY).put(AttributeValue.HIGH, 1.15);
		attributeMap.get(Attribute.RELY).put(AttributeValue.VERY_HIGH, 1.40);
		attributeMap.get(Attribute.RELY).put(AttributeValue.EXTRA_HIGH, 0.0);

		attributeMap.get(Attribute.DATA).put(AttributeValue.VERY_LOW, 0.0);
		attributeMap.get(Attribute.DATA).put(AttributeValue.LOW, 0.94);
		attributeMap.get(Attribute.DATA).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.DATA).put(AttributeValue.HIGH, 1.08);
		attributeMap.get(Attribute.DATA).put(AttributeValue.VERY_HIGH, 1.16);
		attributeMap.get(Attribute.DATA).put(AttributeValue.EXTRA_HIGH, 0.0);

		attributeMap.get(Attribute.CPLX).put(AttributeValue.VERY_LOW, 0.70);
		attributeMap.get(Attribute.CPLX).put(AttributeValue.LOW, 0.85);
		attributeMap.get(Attribute.CPLX).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.CPLX).put(AttributeValue.HIGH, 1.15);
		attributeMap.get(Attribute.CPLX).put(AttributeValue.VERY_HIGH, 1.30);
		attributeMap.get(Attribute.CPLX).put(AttributeValue.EXTRA_HIGH, 1.65);

		attributeMap.get(Attribute.TIME).put(AttributeValue.VERY_LOW, 0.0);
		attributeMap.get(Attribute.TIME).put(AttributeValue.LOW, 0.0);
		attributeMap.get(Attribute.TIME).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.TIME).put(AttributeValue.HIGH, 1.11);
		attributeMap.get(Attribute.TIME).put(AttributeValue.VERY_HIGH, 1.30);
		attributeMap.get(Attribute.TIME).put(AttributeValue.EXTRA_HIGH, 1.66);

		attributeMap.get(Attribute.STOR).put(AttributeValue.VERY_LOW, 0.0);
		attributeMap.get(Attribute.STOR).put(AttributeValue.LOW, 0.0);
		attributeMap.get(Attribute.STOR).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.STOR).put(AttributeValue.HIGH, 1.06);
		attributeMap.get(Attribute.STOR).put(AttributeValue.VERY_HIGH, 1.21);
		attributeMap.get(Attribute.STOR).put(AttributeValue.EXTRA_HIGH, 1.56);

		attributeMap.get(Attribute.VIRT).put(AttributeValue.VERY_LOW, 0.0);
		attributeMap.get(Attribute.VIRT).put(AttributeValue.LOW, 0.87);
		attributeMap.get(Attribute.VIRT).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.VIRT).put(AttributeValue.HIGH, 1.15);
		attributeMap.get(Attribute.VIRT).put(AttributeValue.VERY_HIGH, 1.30);
		attributeMap.get(Attribute.VIRT).put(AttributeValue.EXTRA_HIGH, 1.0);

		attributeMap.get(Attribute.TURN).put(AttributeValue.VERY_LOW, 0.0);
		attributeMap.get(Attribute.TURN).put(AttributeValue.LOW, 0.87);
		attributeMap.get(Attribute.TURN).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.TURN).put(AttributeValue.HIGH, 1.07);
		attributeMap.get(Attribute.TURN).put(AttributeValue.VERY_HIGH, 1.15);
		attributeMap.get(Attribute.TURN).put(AttributeValue.EXTRA_HIGH, 0.0);

		attributeMap.get(Attribute.ACAP).put(AttributeValue.VERY_LOW, 1.46);
		attributeMap.get(Attribute.ACAP).put(AttributeValue.LOW, 1.19);
		attributeMap.get(Attribute.ACAP).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.ACAP).put(AttributeValue.HIGH, 0.86);
		attributeMap.get(Attribute.ACAP).put(AttributeValue.VERY_HIGH, 0.71);
		attributeMap.get(Attribute.ACAP).put(AttributeValue.EXTRA_HIGH, 0.0);

		attributeMap.get(Attribute.AEXP).put(AttributeValue.VERY_LOW, 1.29);
		attributeMap.get(Attribute.AEXP).put(AttributeValue.LOW, 1.13);
		attributeMap.get(Attribute.AEXP).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.AEXP).put(AttributeValue.HIGH, 0.91);
		attributeMap.get(Attribute.AEXP).put(AttributeValue.VERY_HIGH, 0.82);
		attributeMap.get(Attribute.AEXP).put(AttributeValue.EXTRA_HIGH, 0.0);

		attributeMap.get(Attribute.PCAP).put(AttributeValue.VERY_LOW, 1.42);
		attributeMap.get(Attribute.PCAP).put(AttributeValue.LOW, 1.17);
		attributeMap.get(Attribute.PCAP).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.PCAP).put(AttributeValue.HIGH, 0.86);
		attributeMap.get(Attribute.PCAP).put(AttributeValue.VERY_HIGH, 0.70);
		attributeMap.get(Attribute.PCAP).put(AttributeValue.EXTRA_HIGH, 0.0);

		attributeMap.get(Attribute.VEXP).put(AttributeValue.VERY_LOW, 1.21);
		attributeMap.get(Attribute.VEXP).put(AttributeValue.LOW, 1.10);
		attributeMap.get(Attribute.VEXP).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.VEXP).put(AttributeValue.HIGH, 0.90);
		attributeMap.get(Attribute.VEXP).put(AttributeValue.VERY_HIGH, 0.0);
		attributeMap.get(Attribute.VEXP).put(AttributeValue.EXTRA_HIGH, 0.0);

		attributeMap.get(Attribute.LEXP).put(AttributeValue.VERY_LOW, 1.14);
		attributeMap.get(Attribute.LEXP).put(AttributeValue.LOW, 1.07);
		attributeMap.get(Attribute.LEXP).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.LEXP).put(AttributeValue.HIGH, 0.95);
		attributeMap.get(Attribute.LEXP).put(AttributeValue.VERY_HIGH, 0.0);
		attributeMap.get(Attribute.LEXP).put(AttributeValue.EXTRA_HIGH, 0.0);

		attributeMap.get(Attribute.MODP).put(AttributeValue.VERY_LOW, 1.24);
		attributeMap.get(Attribute.MODP).put(AttributeValue.LOW, 1.10);
		attributeMap.get(Attribute.MODP).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.MODP).put(AttributeValue.HIGH, 0.91);
		attributeMap.get(Attribute.MODP).put(AttributeValue.VERY_HIGH, 0.82);
		attributeMap.get(Attribute.MODP).put(AttributeValue.EXTRA_HIGH, 0.0);

		attributeMap.get(Attribute.TOOL).put(AttributeValue.VERY_LOW, 1.24);
		attributeMap.get(Attribute.TOOL).put(AttributeValue.LOW, 1.10);
		attributeMap.get(Attribute.TOOL).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.TOOL).put(AttributeValue.HIGH, 0.91);
		attributeMap.get(Attribute.TOOL).put(AttributeValue.VERY_HIGH, 0.83);
		attributeMap.get(Attribute.TOOL).put(AttributeValue.EXTRA_HIGH, 0.0);

		attributeMap.get(Attribute.SCED).put(AttributeValue.VERY_LOW, 1.23);
		attributeMap.get(Attribute.SCED).put(AttributeValue.LOW, 1.08);
		attributeMap.get(Attribute.SCED).put(AttributeValue.NOMINAL, 1.0);
		attributeMap.get(Attribute.SCED).put(AttributeValue.HIGH, 1.04);
		attributeMap.get(Attribute.SCED).put(AttributeValue.VERY_HIGH, 1.10);
		attributeMap.get(Attribute.SCED).put(AttributeValue.EXTRA_HIGH, 0.0);

	}	

	public Project(List<String> attributes){
		attribCategorial = new HashMap<Attribute, Double>();
		attribNumerical = new HashMap<Attribute, Double>();
		Iterator<String> iter = attributes.iterator();
		for (Attribute att : EnumSet.range(Attribute.RELY, Attribute.SCED)) {
			try {
				attribCategorial.put(att, attributeMap.get(att).
					get(stringToAttributeValue(iter.next())));
			} catch (IllegalArgumentException nfe) {
				nfe.printStackTrace();
			}
		}

		for (Attribute att : EnumSet.range(Attribute.LOC, Attribute.ACT_EFFORT)) {
			try {
				attribNumerical.put(att, Double.parseDouble(iter.next()));
			} catch (NumberFormatException nfe) {
				nfe.printStackTrace();
			}
		}
	}
		
	private void setAttribute(Attribute attr, AttributeValue value){
		this.attribCategorial.put(attr, attributeMap.get(attr).get(value));	
	}

	private void setAttribute(Attribute attr, double value){
		this.attribNumerical.put(attr, value);	
	}

	public double getAttribute(Attribute attr){
		if(attribCategorial.containsKey(attr)){
			return this.attribCategorial.get(attr);
		} else {
			return this.attribNumerical.get(attr);
		}
	}

	public double calculateSimilarity(Project rhs, ProjectDB db) {
		double distance = 0.0;
		for (Attribute a : attribCategorial.keySet()) {
			if (attribCategorial.get(a) != rhs.getAttribute(a)) {
				distance += 1;
			}
		}

		for (Attribute a : attribNumerical.keySet()) {
			distance += Math.pow((attribNumerical.get(a) - rhs.getAttribute(a)) / (db.getMaxAttrib(a) - db.getMinAttrib(a)) , 2);
		}

		double similarity = 1 - Math.sqrt(distance/(attribCategorial.size() + attribNumerical.size()));
		return similarity;
	}
	
	/* see lecture 1 page 9. */
	public double calculateEffort(List<Project> similarProjects){
		return 0.0;
	}

	private AttributeValue stringToAttributeValue(String str) throws IllegalArgumentException{
		if(str.equalsIgnoreCase("VERY_LOW")){
			return AttributeValue.VERY_LOW;
		} else if(str.equalsIgnoreCase("LOW")){
			return AttributeValue.LOW;
		} else if(str.equalsIgnoreCase("NOMINAL")){
			return AttributeValue.NOMINAL;
		} else if(str.equalsIgnoreCase("HIGH")){
			return AttributeValue.HIGH;
		} else if(str.equalsIgnoreCase("VERY_HIGH")){
			return AttributeValue.VERY_HIGH;
		} else if(str.equalsIgnoreCase("EXTRA_HIGH")){
			return AttributeValue.EXTRA_HIGH;
		} else {
			throw new IllegalArgumentException("Unsupported attibute value: " + str);
		}
	}
}
