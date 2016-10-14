package com.octest.beans;

public class Candidat {
	
	private int id_candidature ;
	
	private int id_offre ;
	
	private String nomFichier ;
	
	private String position ;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getId_candidature() {
		return id_candidature;
	}

	public void setId_candidature(int id_candidature) {
		this.id_candidature = id_candidature;
	}

	public int getId_offre() {
		return id_offre;
	}

	public void setId_offre(int id_offre) {
		this.id_offre = id_offre;
	}

	public String getNomFichier() {
		return nomFichier;
	}

	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}

	
}
