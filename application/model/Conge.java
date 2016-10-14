package com.octest.beans;

import java.util.Date;

public class Conge {
	
	private String matricule ;
	
	private Date Datedeb ;
	
	private int jours_demande ;
	
	public int getJours_demande() {
		return jours_demande;
	}

	public void setJours_demande(int jours_demande) {
		this.jours_demande = jours_demande;
	}

	private String type_conge ;
	
	private String reponse ;
	
	
	
	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	public Date getDatedeb() {
		return Datedeb;
	}

	public void setDatedeb(Date date) {
		this.Datedeb = date;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	
	public String getType_conge() {
		return type_conge;
	}

	public void setType_conge(String type_conge) {
		this.type_conge = type_conge;
	}



}
