package com.octest.beans;

import java.util.Date;

public class Formation {
 	 
    private int id ;
    
    private String service ;
    
    private String theme ;
    
    private int priorite ;
    
    private int dure_moy ;
    
    private float budget ;
    
    private Date date_debut ;
    
    private String lieu ;
    
    private String etat ;
    
    private Date date_fin ;

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public int getDure_moy() {
		return dure_moy;
	}

	public void setDure_moy(int dure_moy) {
		this.dure_moy = dure_moy;
	}

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	} 
	

}
