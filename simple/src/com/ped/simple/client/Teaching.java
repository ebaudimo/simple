package com.ped.simple.client;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



enum TeachingType {
	COURS("COURS"),
	EI("EI"),
	TD("TD"),
	TP("TP");

	private final String stringValue;

	private TeachingType() {
		stringValue = "";
	}

	private TeachingType(final String s) {
		stringValue = s;
	}

	public String toString() {
		return stringValue;
	}
}

@XmlRootElement(name = "teaching")
public class Teaching implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private int id;

	
	private TeachingType type;

	private String teacher;

	private int nbHour;

	private int nbSceance;

	private int numGroup;

	private List<Integer> sceances;


	private String module;



	public Teaching() {

	}

	public Teaching(TeachingType type, String teacher, int nbHour, int nbSceance, int numGroup, List<Integer> sceances, String module) {
		this.type = type;
		this.teacher = teacher;
		this.nbHour = nbHour;
		this.nbSceance = nbSceance;
		this.numGroup = numGroup;
		this.sceances = sceances;
		this.module = module;
	}



	@XmlElement
	public int getId() {
		return id;
	}

	@XmlElement
	public TeachingType getType() {
		return type;
	}

	public void setType(TeachingType type) {
		this.type = type;
	}

	@XmlElement
	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	@XmlElement
	public int getNbHour() {
		return nbHour;
	}

	public void setNbHour(int nbHour) {
		this.nbHour = nbHour;
	}

	@XmlElement
	public int getNbSceance() {
		return nbSceance;
	}

	public void setNbSceance(int nbSceance) {
		this.nbSceance = nbSceance;
	}

	@XmlElement
	public int getNumGroup() {
		return numGroup;
	}

	public void setNumGroup(int numGroup) {
		this.numGroup = numGroup;
	}

	@XmlElement
	public List<Integer> getSceances() {
		return sceances;
	}

	public void setSceances(List<Integer> sceances) {
		this.sceances = sceances;
	}

	@XmlElement
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}
}