package com.octest.beans;

import java.util.Date;

public class Utilisateur {

    
	private String matricule ;
	
	private String password ;
	
	private String nom;

    private String prenom;
    
    private String position;
    
	private Date deb_contrat;
	
	private Date fin_contrat;
	
	private String email;
	
	private String phone;
	
	private String service;
	
	private String login ;
	
	private String adresse ;
	
	private String ville ;
	
	private String pays ;
	
	private float paie_heure ;
	
	private float pex_heure ;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getDeb_contrat() {
		return deb_contrat;
	}

	public void setDeb_contrat(Date deb_contrat) {
		this.deb_contrat = deb_contrat;
	}

	public Date getFin_contrat() {
		return fin_contrat;
	}

	public void setFin_contrat(Date fin_contrat) {
		this.fin_contrat = fin_contrat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public float getPaie_heure() {
		return paie_heure;
	}

	public void setPaie_heure(float paie_heure) {
		this.paie_heure = paie_heure;
	}

	public float getPex_heure() {
		return pex_heure;
	}

	public void setPex_heure(float pex_heure) {
		this.pex_heure = pex_heure;
	}
	
 

	
}