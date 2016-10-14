package com.octest.beans;

import java.util.Date;

public class Salary {
	
    private int id ;
    
	private String matricule ;
    
    private float nb_heures  ;
    
    private float nb_extra ;
    
    private float prime ;
    
    private float impots ;
    
    private Date date ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public float getNb_heures() {
		return nb_heures;
	}

	public void setNb_heures(float nb_heures) {
		this.nb_heures = nb_heures;
	}

	public float getNb_extra() {
		return nb_extra;
	}

	public void setNb_extra(float nb_extra) {
		this.nb_extra = nb_extra;
	}

	public float getPrime() {
		return prime;
	}

	public void setPrime(float prime) {
		this.prime = prime;
	}

	public float getImpots() {
		return impots;
	}

	public void setImpots(float impots) {
		this.impots = impots;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
    
	

    
   
}
