package com.octest.beans;

import java.util.Date;

public class Offre {
	
	private int id ;
	
	private String position ;
	
	private String competences ;
	
	private int experience ;
	
	private String description ;
	
	private Date date_limite ;
	
	private Date date_pub ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompetences() {
		return competences;
	}

	public void setCompetences(String competences) {
		this.competences = competences;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_limite() {
		return date_limite;
	}

	public void setDate_limite(Date date_limite) {
		this.date_limite = date_limite;
	}

	public Date getDate_pub() {
		return date_pub;
	}

	public void setDate_pub(Date date_pub) {
		this.date_pub = date_pub;
	}

}
