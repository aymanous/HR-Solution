package com.octest.bdd;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.octest.beans.Candidat;
import com.octest.beans.Conge;
import com.octest.beans.Formation;
import com.octest.beans.Message;
import com.octest.beans.Mission;
import com.octest.beans.Recrutement;
import com.octest.beans.Salary;
import com.octest.beans.Utilisateur;
import com.octest.beans.Offre;
import com.octest.beans.Pointage;


public class Noms {

    private Connection connexion ;

    
    
    

    public List<Utilisateur> recupererUtilisateurs() {

        ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

        Statement statement = null;

        ResultSet resultat = null;


        loadDatabase();

       

        try {

            statement = connexion.createStatement();


            // Exécution de la requête

            resultat = statement.executeQuery("SELECT * FROM noms;");


            // Récupération des données

            while (resultat.next()) {
            	
            	String matricule = resultat.getString("matricule");

                String nom = resultat.getString("nom");

                String prenom = resultat.getString("prenom");
                
                String password = resultat.getString("password");

                String position = resultat.getString("position");
                
                Date deb_contrat = resultat.getDate("deb_contrat");
                
                Date fin_contrat = resultat.getDate("fin_contrat");
                
                String email = resultat.getString("email");
                
                String phone = resultat.getString("phone");
                
                String service = resultat.getString("service");
                
                String login = resultat.getString("login");
                
                String adresse = resultat.getString("adresse");
                
                String ville = resultat.getString("ville");
                
                String pays = resultat.getString("pays");
                
                float paie_heure = resultat.getFloat("paie_heure");
                
                float pex_heure = resultat.getFloat("pex_heure");
 
                
                

                Utilisateur utilisateur = new Utilisateur();
                
                utilisateur.setMatricule(matricule);
                
                utilisateur.setNom(nom);

                utilisateur.setPrenom(prenom);
                
                utilisateur.setPassword(password);

                utilisateur.setPosition(position);
                
                utilisateur.setDeb_contrat(deb_contrat);
                
                utilisateur.setFin_contrat(fin_contrat);
                
                utilisateur.setEmail(email);
                
                utilisateur.setPhone(phone);
                
                utilisateur.setService(service);
                
                utilisateur.setLogin(login);
                
                utilisateur.setAdresse(adresse);
                
                utilisateur.setVille(ville);
                
                utilisateur.setPays(pays);
                
                utilisateur.setPaie_heure(paie_heure);
                
                utilisateur.setPex_heure(pex_heure);
                
                
                
                utilisateurs.add(utilisateur);

            }

        } catch (SQLException e) {

        } finally {

            // Fermeture de la connexion

            try {

                if (resultat != null)

                    resultat.close();

                if (statement != null)

                    statement.close();

                if (connexion != null)

                    connexion.close();

            } catch (SQLException ignore) {

            }

        }

        

        return utilisateurs;

    }

    

    private void loadDatabase() {

        // Chargement du driver

        try {

            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {

        }


        try {

            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaee", "root", "root");

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    

    public void Ajouter_Employe(Utilisateur utilisateur) {

        loadDatabase();
       

        

        try {

            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO noms (matricule, password, nom, prenom, position, deb_contrat, fin_contrat, email, phone, service, login, adresse, ville, pays, paie_heure, pex_heure) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ;");

            preparedStatement.setString(1, utilisateur.getMatricule());

            preparedStatement.setString(2, utilisateur.getPassword());
            
            preparedStatement.setString(3, utilisateur.getNom());
            
            preparedStatement.setString(4, utilisateur.getPrenom());
            
            preparedStatement.setString(5, utilisateur.getPosition());
            
            java.sql.Date sqlDate = new java.sql.Date(utilisateur.getDeb_contrat().getTime()) ;
            
            preparedStatement.setDate(6, sqlDate);
            
            sqlDate = new java.sql.Date(utilisateur.getFin_contrat().getTime()) ;
            
            preparedStatement.setDate(7, sqlDate);
            
            preparedStatement.setString(8, utilisateur.getEmail());
            
            preparedStatement.setString(9, utilisateur.getPhone());
            
            preparedStatement.setString(10, utilisateur.getService());
            
            preparedStatement.setString(11, utilisateur.getLogin());
            
            preparedStatement.setString(12, utilisateur.getAdresse());
            
            preparedStatement.setString(13, utilisateur.getVille());
            
            preparedStatement.setString(14, utilisateur.getPays());
            
            preparedStatement.setFloat(15, utilisateur.getPaie_heure());
            
            preparedStatement.setFloat(16, utilisateur.getPex_heure());
            
      
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }



	public String getPosition(Utilisateur utilisateur) {
		
		String position = "";
        loadDatabase();
        ResultSet resultat = null;
           

        try {

            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT position FROM noms WHERE matricule= ? and password= ?;");

            preparedStatement.setString(1, utilisateur.getMatricule());

            preparedStatement.setString(2, utilisateur.getPassword());

            resultat = preparedStatement.executeQuery();
            
            if (resultat.next()) {
               position = resultat.getString("position"); 
            }
          
            

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
      
		return position;

		
	}

	public void  Mise_A_Jour(Utilisateur utilisateur) {
		
		 loadDatabase();
		 
		 try {

	            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE noms SET password= ?, nom= ?, prenom= ?, service= ?, position= ?, deb_contrat= ?, fin_contrat= ?, email= ?, phone= ?, login= ?, adresse= ?, ville= ?, pays= ?, paie_heure= ?, pex_heure= ? WHERE matricule= ?;" );

	            preparedStatement.setString(1, utilisateur.getPassword());
	            
	            preparedStatement.setString(2, utilisateur.getNom());

	            preparedStatement.setString(3, utilisateur.getPrenom());
	            
	            preparedStatement.setString(4, utilisateur.getService());
	            
	            preparedStatement.setString(5, utilisateur.getPosition());
	            
	            java.sql.Date sqlDate = new java.sql.Date(utilisateur.getDeb_contrat().getTime()) ;
	                       
	            preparedStatement.setDate(6, sqlDate);
	            
	            sqlDate = new java.sql.Date(utilisateur.getFin_contrat().getTime()) ;
	            
	            preparedStatement.setDate(7, sqlDate);
	            
	            preparedStatement.setString(8, utilisateur.getEmail());
	            
	            preparedStatement.setString(9, utilisateur.getPhone());
	            
	            preparedStatement.setString(10, utilisateur.getLogin());
	            
	            preparedStatement.setString(11, utilisateur.getAdresse());
	            
	            preparedStatement.setString(12, utilisateur.getVille());
	            
	            preparedStatement.setString(13, utilisateur.getPays());
	            
	            preparedStatement.setFloat(14, utilisateur.getPaie_heure());
	            
	            preparedStatement.setFloat(15, utilisateur.getPex_heure());
	            
	            preparedStatement.setString(16, utilisateur.getMatricule());

	            
	            preparedStatement.executeUpdate() ;
	            
	     
	                  

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
	        
	}



	public void Supprimer_Employe(String matricule) {
		
		loadDatabase();
		try {

            PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM noms WHERE matricule = ?;" );

            
            preparedStatement.setString(1, matricule);

            
            preparedStatement.executeUpdate() ;
            
     
                  

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
		
		
	}



	public List<Conge> recupperer_conges() {
		
		 ArrayList<Conge> conges = new ArrayList<Conge>();

	        Statement statement = null;

	        ResultSet resultat = null;


	        loadDatabase();

	       

	        try {

	            statement = connexion.createStatement();


	            // Exécution de la requête

	            resultat = statement.executeQuery("SELECT matricule, datedeb, jours_demande, type_conge, reponse FROM conges;");


	            // Récupération des données

	            while (resultat.next()) {

	                String matricule = resultat.getString("matricule");

	                Date datedeb = resultat.getDate("datedeb");

	                int jours_demande = resultat.getInt("jours_demande");
	                
	                String type_conge = resultat.getString("type_conge");
	                
	                String reponse = resultat.getString("reponse");
	                
	                Conge conge = new Conge();

	                conge.setMatricule(matricule);

	                conge.setDatedeb(datedeb);

	                conge.setJours_demande(jours_demande);
	                
	                conge.setType_conge(type_conge);
	                
	                conge.setReponse(reponse);

	                conges.add(conge);

	            }

	        } catch (SQLException e) {

	        } finally {

	            // Fermeture de la connexion

	            try {

	                if (resultat != null)

	                    resultat.close();

	                if (statement != null)

	                    statement.close();

	                if (connexion != null)

	                    connexion.close();

	            } catch (SQLException ignore) {

	            }

	        }

	        

	        return conges;

	}



	public void update_conge(Conge conge) {
		
 loadDatabase();
		 
		 try {

	            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE conges SET reponse= ?  WHERE matricule= ? and datedeb= ? and jours_demande= ?;" );

	            preparedStatement.setString(1, conge.getReponse());
	            
	            preparedStatement.setString(2, conge.getMatricule());
	            
	            java.sql.Date sqlDate = new java.sql.Date(conge.getDatedeb().getTime()) ;
	            
	            preparedStatement.setDate(3, sqlDate);

	            preparedStatement.setInt(4, conge.getJours_demande());
	            
	            preparedStatement.executeUpdate() ;
	            
	     
	                  

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
	        
		
		
		
	}



	public Salary recupperer_salaire(int id) {
		
		     Salary salary = new Salary(); 

	         ResultSet resultat = null;


	        loadDatabase();
	        
	        try {

	            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT matricule, nb_heures, nb_extra, prime, impots, date FROM salaire WHERE id= ?;");

	            preparedStatement.setInt(1, id);

	            resultat = preparedStatement.executeQuery();
	            
	            if (resultat.next()) {
 
	            	salary.setId(id);
	            	
	            	salary.setMatricule(resultat.getString("matricule"));
	            	
	                salary.setNb_heures(resultat.getFloat("nb_heures"));
	                
	                salary.setNb_extra(resultat.getFloat("nb_extra"));
	                
	                salary.setPrime(resultat.getFloat("prime")) ;
	                
	                salary.setImpots(resultat.getFloat("impots"));
	                
	                salary.setDate(resultat.getDate("date"));
	               
	            }
	          
	            

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
	        

	       


	        return salary;

	}



	public void Update_salaire(Salary salary) {
		
		loadDatabase();
		 
		 try {

	            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE salaire SET prime= ?, impots= ? WHERE id= ?;" );
 	            
	            preparedStatement.setFloat(1, salary.getPrime());
	            
	            preparedStatement.setFloat(2, salary.getImpots());
	            
	            preparedStatement.setInt(3, salary.getId());
	               
	            preparedStatement.executeUpdate() ;
	            
	     
	                  

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
	        
			
	}



	public Utilisateur recupererUtilisateur(String matricule) {
		
		Utilisateur utilisateur = new Utilisateur();

        Statement statement = null;

        ResultSet resultat = null;


        loadDatabase();

       

        try {

           // Exécution de la requête

            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM noms where matricule= ?;");

            preparedStatement.setString(1, matricule);

            resultat = preparedStatement.executeQuery();

            // Récupération des données

            while (resultat.next()) {
            	
                String nom = resultat.getString("nom");

                String prenom = resultat.getString("prenom");
                
                String password = resultat.getString("password");

                String position = resultat.getString("position");
                
                Date deb_contrat = resultat.getDate("deb_contrat");
                
                Date fin_contrat = resultat.getDate("fin_contrat");
                
                String email = resultat.getString("email");
                
                String phone = resultat.getString("phone");
                
                String service = resultat.getString("service");
                
                String login = resultat.getString("login");
                
                String adresse = resultat.getString("adresse");
                
                String ville = resultat.getString("ville");
                
                String pays = resultat.getString("pays");
                
                float paie_heure = resultat.getFloat("paie_heure");
                
                float pex_heure = resultat.getFloat("pex_heure");

                
            
                
                utilisateur.setMatricule(matricule);
                
                utilisateur.setNom(nom);

                utilisateur.setPrenom(prenom);
                
                utilisateur.setPassword(password);

                utilisateur.setPosition(position);
                
                utilisateur.setDeb_contrat(deb_contrat);
                
                utilisateur.setFin_contrat(fin_contrat);
                
                utilisateur.setEmail(email);
                
                utilisateur.setPhone(phone);
                
                utilisateur.setService(service);
                
                utilisateur.setLogin(login);
                
                utilisateur.setAdresse(adresse);
                
                utilisateur.setVille(ville);
                
                utilisateur.setPays(pays);
                
                utilisateur.setPaie_heure(paie_heure);
                
                utilisateur.setPex_heure(pex_heure);
                
                
            }

        } catch (SQLException e) {

        } finally {

            // Fermeture de la connexion

            try {

                if (resultat != null)

                    resultat.close();

                if (statement != null)

                    statement.close();

                if (connexion != null)

                    connexion.close();

            } catch (SQLException ignore) {

            }

        }

        

        return utilisateur;

	}



	public List<Conge> recupperer_Employe_Conges(String matricule) {
		
		    ArrayList<Conge> conges = new ArrayList<Conge>();

	        ResultSet resultat = null;


	        loadDatabase();

	       

	        try {


	            // Exécution de la requête

	           PreparedStatement preparedStatement = connexion.prepareStatement("SELECT datedeb, jours_demande, type_conge, reponse FROM conges where matricule= ?;");

	           preparedStatement.setString(1, matricule);

	           resultat = preparedStatement.executeQuery();

	            // Récupération des données

	            while (resultat.next()) {

	                Date datedeb = resultat.getDate("datedeb");

	                int jours_demande = resultat.getInt("jours_demande");
	                
	                String type_conge = resultat.getString("type_conge");
	                
	                String reponse = resultat.getString("reponse");
	                
	                Conge conge = new Conge();
	                
	                conge.setMatricule(matricule);

	                conge.setDatedeb(datedeb);

	                conge.setJours_demande(jours_demande);
	                
	                conge.setType_conge(type_conge);
	                
	                conge.setReponse(reponse);

	                conges.add(conge);

	            }

	        } catch (SQLException e) {

	        } finally {

	            // Fermeture de la connexion

	            try {

	                if (resultat != null)

	                    resultat.close();

	                if (connexion != null)

	                    connexion.close();

	            } catch (SQLException ignore) {

	            }

	        }

	        

	        return conges;


	}







	public void add_conge(Conge conge) {
		
       loadDatabase();
       
        try {

            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO conges (matricule, datedeb, jours_demande, type_conge) VALUES ( ?, ?, ?, ?);");

            preparedStatement.setString(1, conge.getMatricule());
            
            java.sql.Date sqlDate = new java.sql.Date(conge.getDatedeb().getTime()) ;
            
            preparedStatement.setDate(2, sqlDate);

            preparedStatement.setInt(3, conge.getJours_demande());
            
            preparedStatement.setString(4, conge.getType_conge());
           
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
		
		
		
	}



	public String getPosition(String matricule) {
		
		String position = null;
        loadDatabase();
        ResultSet resultat = null;
           

        try {

            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT position FROM noms WHERE matricule= ?;");

            preparedStatement.setString(1, matricule);

            resultat = preparedStatement.executeQuery();
            
            if (resultat.next()) {
               position = resultat.getString("position"); 
            }
          
            

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
      
		return position;

		

	}



	public String getService(String matricule) {
		
		String service = "";
        loadDatabase();
        ResultSet resultat = null;
           

        try {

            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT service FROM noms WHERE matricule= ?;");

            preparedStatement.setString(1, matricule);

            resultat = preparedStatement.executeQuery();
            
            if (resultat.next()) {
               service = resultat.getString("service"); 
            }
          
            

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
      
		return service;

		

	}



	public List<Utilisateur> recupererEquipe(String service) {
		
    		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	        ResultSet resultat = null;


	        loadDatabase();

	       

	        try {


	            // Exécution de la requête

	            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT matricule, nom, prenom, position, deb_contrat, fin_contrat, email, phone FROM noms where service= ?;");

	            preparedStatement.setString(1, service);
	            
	            resultat = preparedStatement.executeQuery();

	            // Récupération des données

	            while (resultat.next()) {
	            	
	            	String matricule = resultat.getString("matricule");

	                String nom = resultat.getString("nom");

	                String prenom = resultat.getString("prenom");
	                
	                String position = resultat.getString("position");
	                
	                Date deb_contrat = resultat.getDate("deb_contrat");
	                
	                Date fin_contrat = resultat.getDate("fin_contrat");
	                
	                String email = resultat.getString("email");
	                
	                String phone = resultat.getString("phone");
	                	 
	               
	                Utilisateur utilisateur = new Utilisateur();
	                
	                utilisateur.setMatricule(matricule);
	                
	                utilisateur.setNom(nom);

	                utilisateur.setPrenom(prenom);
	                
	                utilisateur.setPosition(position);
	                
	                utilisateur.setDeb_contrat(deb_contrat);
	                
	                utilisateur.setFin_contrat(fin_contrat);
	                
	                utilisateur.setEmail(email);
	                
	                utilisateur.setPhone(phone);
	                
	                utilisateur.setService(service);
	                
	                utilisateurs.add(utilisateur);

	            }

	        } catch (SQLException e) {

	        } finally {

	            // Fermeture de la connexion

	            try {

	                if (resultat != null)

	                    resultat.close();

	     
	                if (connexion != null)

	                    connexion.close();

	            } catch (SQLException ignore) {

	            }

	        }

	        

	        return utilisateurs;
		
	
	}



	public void add_demande_recrutement(Recrutement recrutement) {
		 loadDatabase();
	       
	        try {

	            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO recrutement (service, position, competences, experience) VALUES ( ?, ?, ?, ?);");

	            preparedStatement.setString(1, recrutement.getService());
	            
	            preparedStatement.setString(2, recrutement.getPosition());

	            preparedStatement.setString(3, recrutement.getCompetences());
	            
	            preparedStatement.setInt(4, recrutement.getExperience());
	           
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
			
			
			
		
	}



	public void add_formation(Formation formation) {
		 
		loadDatabase();
	       
	        try {

	            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO formation (service, theme, priorite, dure_moy) VALUES ( ?, ?, ?, ?);");

	            preparedStatement.setString(1, formation.getService());
	            
	            preparedStatement.setString(2, formation.getTheme());
	            
	            preparedStatement.setInt(3, formation.getPriorite());
	            
	            preparedStatement.setInt(4, formation.getDure_moy());
	            
	            preparedStatement.executeUpdate();

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
			
	}




	public void add_designe(String designe, int id_formation) {
		
		loadDatabase();
	       
        try {

            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO participants (matricule, id_formation) VALUES ( ?, ?);");

            preparedStatement.setString(1, designe);
            
            preparedStatement.setInt(2, id_formation);
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
		
		
		
	}



	public int getId_formation() {

		int id = 0 ;
		
        loadDatabase();
        
        Statement statement = null;

        ResultSet resultat = null;
           

        try {
        	statement = connexion.createStatement();
        	
            // Exécution de la requête

            resultat = statement.executeQuery("SELECT Max(id) FROM formation");
            
            if (resultat.next()) {
               id = resultat.getInt(1) ;
            }
          
            

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
      		
		return id;
	}



	public List<Formation> recupperer_formations() {
	        ArrayList<Formation> formations = new ArrayList<Formation>();

	        Statement statement = null;

	        ResultSet resultat = null;


	        loadDatabase();

	       

	        try {

	            statement = connexion.createStatement();


	            // Exécution de la requête

	            resultat = statement.executeQuery("SELECT id, service, theme, priorite, dure_moy, budget, date_debut, date_fin, etat, lieu FROM formation;");


	            // Récupération des données

	            while (resultat.next()) {
	            	
	            	int id = resultat.getInt("id");

	                String service = resultat.getString("service");

	                String theme = resultat.getString("theme");
	                
	                int priorite = resultat.getInt("priorite") ;

	                int dure_moy = resultat.getInt("dure_moy") ;
	                
	                float budget = resultat.getFloat("budget") ;
	                
	                Date date_debut = resultat.getDate("date_debut") ;
	                
	                Date date_fin = resultat.getDate("date_fin") ;
	                
	                String lieu = resultat.getString("lieu");
	             
	                String etat = resultat.getString("etat");

	                Formation formation = new Formation();
	                
	                formation.setId(id);
	                
	                formation.setService(service);

	                formation.setTheme(theme);
	                
	                formation.setPriorite(priorite);
	                
	                formation.setDure_moy(dure_moy);
	                
	                formation.setBudget(budget);
	                
	                formation.setDate_debut(date_debut);
	                
	                formation.setDate_fin(date_fin);
	                
	                formation.setLieu(lieu);
	                
	                formation.setEtat(etat);
	                
	                formations.add(formation);

	            }

	        } catch (SQLException e) {

	        } finally {

	            // Fermeture de la connexion

	            try {

	                if (resultat != null)

	                    resultat.close();

	                if (statement != null)

	                    statement.close();

	                if (connexion != null)

	                    connexion.close();

	            } catch (SQLException ignore) {

	            }

	        }

	        

	        return formations;
		
	}



	public List<Utilisateur> recupperer_designes(int id) {
		
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

        ResultSet resultat = null;
        


        loadDatabase();

       

        try {



	            // Exécution de la requête

        	 PreparedStatement preparedStatement = connexion.prepareStatement("SELECT matricule, nom, prenom from noms NATURAL JOIN participants where id_formation= ?;");

             preparedStatement.setInt(1, id);

             resultat = preparedStatement.executeQuery();
             
            // Récupération des données

            while (resultat.next()) {
            	
            	String matricule = resultat.getString("matricule");

                String nom = resultat.getString("nom");

                String prenom = resultat.getString("prenom");	 
               
                Utilisateur utilisateur = new Utilisateur();
               
                utilisateur.setMatricule(matricule);
                
                utilisateur.setNom(nom);

                utilisateur.setPrenom(prenom);
                
                utilisateurs.add(utilisateur);

            }

        } catch (SQLException e) {

        } finally {

            // Fermeture de la connexion

            try {

                if (resultat != null)

                    resultat.close();

     
                if (connexion != null)

                    connexion.close();

            } catch (SQLException ignore) {

            }

        }

        

        return utilisateurs;
	
		

	}



	public void update_formation(Formation formation) {
		
		loadDatabase();
		 
		 try {

	            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE formation SET service= ?, theme= ?, priorite= ?, dure_moy= ?, budget= ?, date_debut= ?, date_fin= ?, lieu = ? WHERE id= ?;" );

	            preparedStatement.setString(1, formation.getService());
	            
	            preparedStatement.setString(2, formation.getTheme());
	            
	            preparedStatement.setInt(3, formation.getPriorite());
	            
	            preparedStatement.setInt(4, formation.getDure_moy());
	            
	            preparedStatement.setFloat(5, formation.getBudget());
	            
	            java.sql.Date sqlDate = new java.sql.Date(formation.getDate_debut().getTime()) ;
	            	            
	            preparedStatement.setDate(6, sqlDate);
	            
	            sqlDate = new java.sql.Date(formation.getDate_fin().getTime()) ;
	            
	            preparedStatement.setDate(7, sqlDate);
	            
	            preparedStatement.setString(8, formation.getLieu());
	            
	            preparedStatement.setInt(9, formation.getId());
	            
	            preparedStatement.executeUpdate() ;
	            
	     
	                  

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
	        
		
		// TODO Auto-generated method stub
		
		
		
	}



	public void update_etat_formation(int id, String etat) {
		
		loadDatabase();
		 
		 try {

	            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE formation SET etat= ? WHERE id= ?;" );

	            preparedStatement.setString(1, etat);
	            
	            preparedStatement.setInt(2, id);
	            
	            preparedStatement.executeUpdate() ;
	            
	     
	                  

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
	        
		
		// TODO Auto-generated method stub
		
		
	
		
		
	}



	public List<Integer> recupperer_employe_formations(String matricule) {

		    ArrayList<Integer> ids = new ArrayList<Integer>();

	        ResultSet resultat = null;

	        loadDatabase();

	       

	        try {


	            // Exécution de la requête

	           PreparedStatement preparedStatement = connexion.prepareStatement("SELECT id_formation FROM participants where matricule= ?;");

	           preparedStatement.setString(1, matricule);

	           resultat = preparedStatement.executeQuery();

	            // Récupération des données

	            while (resultat.next()) {

	                int id = resultat.getInt("id_formation");
	                
	                ids.add(id) ;

	            }

	        } catch (SQLException e) {

	        } finally {

	            // Fermeture de la connexion

	            try {

	                if (resultat != null)

	                    resultat.close();

	                if (connexion != null)

	                    connexion.close();

	            } catch (SQLException ignore) {

	            }

	        }

	        

	        return ids;

	}



	public Formation recupperer_info_formation(Integer id) {
		
		Formation formation = new Formation() ;

        Statement statement = null;

        ResultSet resultat = null;


        loadDatabase();

       

        try {

           // Exécution de la requête

            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT id, service, theme, priorite, dure_moy, budget, date_debut, date_fin, lieu, etat  FROM formation where id= ?;");

            preparedStatement.setInt(1, id);

            resultat = preparedStatement.executeQuery();

            // Récupération des données

            while (resultat.next()) {
            	
                String service = resultat.getString("service");

                String theme = resultat.getString("theme");
                
                int priorite = resultat.getInt("priorite");

                int dure_moy = resultat.getInt("dure_moy");
                
                float budget = resultat.getFloat("budget");
                
                Date date_debut = resultat.getDate("date_debut") ;
                
                Date date_fin = resultat.getDate("date_fin") ;
                
                String lieu = resultat.getString("lieu") ;
                
                String etat = resultat.getString("etat") ;
                

                
                
                formation.setId(id);

                formation.setService(service);
                
                formation.setTheme(theme);
                
                formation.setPriorite(priorite);
                
                formation.setDure_moy(dure_moy);
                
                formation.setBudget(budget);
                
                formation.setDate_debut(date_debut);
                
                formation.setDate_fin(date_fin);
                
                formation.setLieu(lieu);
                
                formation.setEtat(etat);
                
            }

        } catch (SQLException e) {

        } finally {

            // Fermeture de la connexion

            try {

                if (resultat != null)

                    resultat.close();

                if (statement != null)

                    statement.close();

                if (connexion != null)

                    connexion.close();

            } catch (SQLException ignore) {

            }

        }

        

        return formation;

		
	}



	public List<Mission> reccupperer_missions(String service) {
		
		ArrayList<Mission> missions = new ArrayList<Mission>();

        ResultSet resultat = null;


        loadDatabase();

       

        try {


            // Exécution de la requête

            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT id, service, objet, description, date_debut, dure, lieu, etat FROM Mission where service= ?;");

            preparedStatement.setString(1, service);
            
            resultat = preparedStatement.executeQuery();

            // Récupération des données

            while (resultat.next()) {
            	
            	int id = resultat.getInt("id") ;

                String m_service = resultat.getString("service");

                String objet = resultat.getString("objet");
                
                String description = resultat.getString("description");

                Date date_debut = resultat.getDate("date_debut");
                
                int dure = resultat.getInt("dure") ;
                
                String lieu = resultat.getString("lieu") ;
                
                String etat = resultat.getString("etat") ;
                
                
                
                Mission mission = new Mission() ;
                
                mission.setId(id);
                
                mission.setService(m_service);

                mission.setObjet(objet);
                
                mission.setDescription(description);

                mission.setDate_debut(date_debut);
                
                mission.setDure(dure);
                
                mission.setEtat(etat);
                
                mission.setLieu(lieu);
                
               missions.add(mission);
            }

        } catch (SQLException e) {

        } finally {

            // Fermeture de la connexion

            try {

                if (resultat != null)

                    resultat.close();

     
                if (connexion != null)

                    connexion.close();

            } catch (SQLException ignore) {

            }

        }

        

        return missions;
		
	}



	public void add_mission(Mission mission) {
		
		loadDatabase();
	       
        try {

            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO Mission (service, objet, description, date_debut, dure, lieu) VALUES ( ?, ?, ?, ?, ?, ?);");

            preparedStatement.setString(1, mission.getService());
            
            preparedStatement.setString(2, mission.getObjet());
            
            preparedStatement.setString(3, mission.getDescription());
            
            java.sql.Date sqlDate = new java.sql.Date(mission.getDate_debut().getTime()) ;
            
            preparedStatement.setDate(4, sqlDate);
            
            preparedStatement.setInt(5, mission.getDure());
            
            preparedStatement.setString(6, mission.getLieu());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
		
	}



	public void Supprimer_mission(int id) {
		
		loadDatabase();
		try {

            PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM Mission WHERE id =?" );

            
            preparedStatement.setInt(1,id);

            
            preparedStatement.executeUpdate() ;
            
     
                  

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
		
		
		
	}



	public void update_mission(Mission mission) {
		
		loadDatabase();
		 
		 try {

	            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE Mission SET service= ?, objet= ?, description= ?, date_debut= ?, dure= ?, lieu= ? WHERE id= ?;" );

	            preparedStatement.setString(1, mission.getService());
	            
	            preparedStatement.setString(2, mission.getObjet());
	            
	            preparedStatement.setString(3, mission.getDescription());
	            
                java.sql.Date sqlDate = new java.sql.Date(mission.getDate_debut().getTime()) ;
	            
	            preparedStatement.setDate(4, sqlDate);
	             
	            preparedStatement.setInt(5, mission.getDure());
	            
	            preparedStatement.setString(6, mission.getLieu());
	            
	            preparedStatement.setInt(7, mission.getId());
	            
	            preparedStatement.executeUpdate() ;
	            
	     
	                  

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
	        
		
		
		
	}



	public int getId_mission() {
        int id = 0 ;
		
        loadDatabase();
        
        Statement statement = null;

        ResultSet resultat = null;
           

        try {
        	statement = connexion.createStatement();
        	
            // Exécution de la requête

            resultat = statement.executeQuery("SELECT Max(id) FROM Mission");
            
            if (resultat.next()) {
               id = resultat.getInt(1) ;
            }
          
            

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
      		
		return id;
	}



	public void add_employe_mission(String matricule, int id) {
		
		loadDatabase();
	       
        try {

            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO Execution (matricule, id_mission) VALUES ( ?, ?);");

            preparedStatement.setString(1, matricule);
            
            preparedStatement.setInt(2, id);
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
		
		
		
		
	}



	public void supprimer_employe_missions(int id) {
		loadDatabase();
		try {

            PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM execution WHERE id_mission =?" );

            
            preparedStatement.setInt(1,id);

            
            preparedStatement.executeUpdate() ;
            
     
                  

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
		
		
	}



	public List<Integer> recupperer_employe_missions(String matricule) {
		
		   ArrayList<Integer> ids = new ArrayList<Integer>();

	        ResultSet resultat = null;

	        loadDatabase();

	       

	        try {


	            // Exécution de la requête

	           PreparedStatement preparedStatement = connexion.prepareStatement("SELECT id_mission FROM execution where matricule= ?;");

	           preparedStatement.setString(1, matricule);

	           resultat = preparedStatement.executeQuery();

	            // Récupération des données

	            while (resultat.next()) {

	                int id = resultat.getInt("id_mission");
	                
	                ids.add(id) ;

	            }

	        } catch (SQLException e) {

	        } finally {

	            // Fermeture de la connexion

	            try {

	                if (resultat != null)

	                    resultat.close();

	                if (connexion != null)

	                    connexion.close();

	            } catch (SQLException ignore) {

	            }

	        }

	        

	        return ids;

	}



	public Mission recupperer_info_mission(Integer id) {
		
		Mission mission = new Mission() ;

        Statement statement = null;

        ResultSet resultat = null;


        loadDatabase();

       

        try {

           // Exécution de la requête

            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT id, service, objet, description, date_debut, dure, lieu, etat FROM Mission where id= ?;");

            preparedStatement.setInt(1, id);

            resultat = preparedStatement.executeQuery();

            // Récupération des données

            while (resultat.next()) {
            	
            	int id_mission = resultat.getInt("id");
            	
                String service = resultat.getString("service");

                String objet = resultat.getString("objet") ;
                
                String description = resultat.getString("description") ;
                
                Date date_debut = resultat.getDate("date_debut") ;
                
                int dure = resultat.getInt("dure");
                
                String lieu = resultat.getString("lieu") ;
                
                String etat = resultat.getString("etat") ;
                

                
                
                mission.setId(id_mission);

                mission.setService(service);
                
                mission.setObjet(objet);
                
                mission.setDescription(description);
                
                mission.setDate_debut(date_debut);
                
                mission.setDure(dure);
                
                mission.setLieu(lieu);
                
                mission.setEtat(etat);
                   
            }

        } catch (SQLException e) {

        } finally {

            // Fermeture de la connexion

            try {

                if (resultat != null)

                    resultat.close();

                if (statement != null)

                    statement.close();

                if (connexion != null)

                    connexion.close();

            } catch (SQLException ignore) {

            }

        }

        

        return mission;

	
		
	}



	public List<Offre> recuperer_offres() {
		
		    ArrayList<Offre> offres = new ArrayList<Offre>();

	        Statement statement = null;

	        ResultSet resultat = null;


	        loadDatabase();

	       

	        try {

	            statement = connexion.createStatement();


	            // Exécution de la requête

	            resultat = statement.executeQuery("SELECT * FROM offre_emploi;");


	            // Récupération des données

	            while (resultat.next()) {
	            	
	            	int id = resultat.getInt("id");

	                String position = resultat.getString("position");

	                String competences = resultat.getString("competences");
	                
	                int experience = resultat.getInt("experience") ;

	                String description = resultat.getString("description") ;
	                
	                Date date_limite = resultat.getDate("date_limite") ;
	                
	                Date date_pub = resultat.getDate("date_pub") ;
	                
	                
	                Offre offre = new Offre() ;
	                
	                offre.setId(id);
	                
	                offre.setPosition(position);
	                
	                offre.setCompetences(competences);
	                
	                offre.setExperience(experience);
	                
	                offre.setDescription(description);
	                
	                offre.setDate_limite(date_limite);
	                
	                offre.setDate_pub(date_pub);
	               
	                
	                
	                offres.add(offre) ;
	            }

	        } catch (SQLException e) {

	        } finally {

	            // Fermeture de la connexion

	            try {

	                if (resultat != null)

	                    resultat.close();

	                if (statement != null)

	                    statement.close();

	                if (connexion != null)

	                    connexion.close();

	            } catch (SQLException ignore) {

	            }

	        }

	        

	        return offres;
		
		
	
	}



	public List<Recrutement> recuperer_d_recrutement() {
    		ArrayList<Recrutement> recrutements = new ArrayList<Recrutement>();
 
	        Statement statement = null;

	        ResultSet resultat = null;


	        loadDatabase();

	       

	        try {

	            statement = connexion.createStatement();

	            // Exécution de la requête

	            resultat = statement.executeQuery("SELECT * FROM Recrutement;");


	            // Récupération des données

	            while (resultat.next()) {
	            	
	            	int id = resultat.getInt("id");

	                String service = resultat.getString("service");

	                String position = resultat.getString("position");
	                
	                String competences = resultat.getString("competences");
	                
	                int experience = resultat.getInt("experience");
	                
	                String etat = resultat.getString("etat");
	                

	                Recrutement recrutement = new Recrutement() ;
	                
	                recrutement.setId(id);
	                
	                recrutement.setService(service);
	               
	                recrutement.setPosition(position);
	               
	                recrutement.setCompetences(competences);
	               
	                recrutement.setExperience(experience);
	                
	                recrutement.setEtat(etat);
	                
	               
	                recrutements.add(recrutement) ;

	            }

	        } catch (SQLException e) {

	        } finally {

	            // Fermeture de la connexion

	            try {

	                if (resultat != null)

	                    resultat.close();

	                if (statement != null)

	                    statement.close();

	                if (connexion != null)

	                    connexion.close();

	            } catch (SQLException ignore) {

	            }

	        }

	        

	        return recrutements;
		
		
		
		

	}



	public void add_offre(Offre offre) {
		
		loadDatabase();
	       
        try {

            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO offre_emploi ( position, competences, experience, description, date_limite, date_pub) VALUES ( ?, ?, ?, ?, ?, now());");

            preparedStatement.setString(1, offre.getPosition());
            
            preparedStatement.setString(2, offre.getCompetences());
            
            preparedStatement.setInt(3, offre.getExperience());
            
            preparedStatement.setString(4, offre.getDescription());
            
            java.sql.Date sqlDate = new java.sql.Date(offre.getDate_limite().getTime()) ;
            
            preparedStatement.setDate(5, sqlDate);
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
		

		
	}



	public void supprimer_offre(int id) {
		
		loadDatabase();
		try {

            PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM offre_emploi WHERE id =?" );

            
            preparedStatement.setInt(1,id);

            
            preparedStatement.executeUpdate() ;
            
     
                  

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
		
		
		
		
	}


	public List<Message> reccupperer_messages(String matricule) {
		
		    ArrayList<Message> messages = new ArrayList<Message>();

	        ResultSet resultat = null;


	        loadDatabase();

	       

	        try {

	            // Exécution de la requête
	        	
	        	 PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Message where destination = ?;");

	             preparedStatement.setString(1, matricule);
	             
	             resultat = preparedStatement.executeQuery();

	         
	            // Récupération des données

	            while (resultat.next()) {
	            	
	            	int id = resultat.getInt("id");

	                String source = resultat.getString("source");

	                String destination = resultat.getString("destination");
	         
	                String objet = resultat.getString("objet") ;
	                
	                String contenu = resultat.getString("contenu") ;
	                
	                Date date = resultat.getDate("date") ;
	                
	                String etat = resultat.getString("etat") ;
	                
	                
	                Message message = new Message() ;
	                
	                message.setId(id);
	                
	                message.setSource(source);
	                
	                message.setDestination(destination);
	                
	                message.setObjet(objet);
	                
	                message.setContenu(contenu);
	                
	                message.setDate(date);
	                
	                message.setEtat(etat);
	                


	                
	              messages.add(message) ;
	            }

	        } catch (SQLException e) {

	        } finally {

	            // Fermeture de la connexion

	            try {

	                if (resultat != null)

	                    resultat.close();

	                if (connexion != null)

	                    connexion.close();

	            } catch (SQLException ignore) {

	            }

	        }

	        

	        return messages;
		
		
	}



	public void marquer_message(int id) {
		
		loadDatabase();
		 
		 try {

	            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE Message SET etat= ?  WHERE id= ?;" );

	            preparedStatement.setString(1,"Vu");
	            
	            preparedStatement.setInt(2, id);
	             
	            preparedStatement.executeUpdate() ;
	            
	     
	                  

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
	        
				
	}



	public void supprimer_message(int id) {
		

		loadDatabase();
		try {

            PreparedStatement preparedStatement = connexion.prepareStatement("DELETE FROM message WHERE id =?" );

            
            preparedStatement.setInt(1,id);

            
            preparedStatement.executeUpdate() ;
            
     
                  

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
		
		
		
		
		
	}



	public void add_message(Message message) {
		
		loadDatabase();
	       
        try {

            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO Message (source, destination, objet, contenu, date) VALUES ( ?, ?, ?, ?, now());");

            preparedStatement.setString(1, message.getSource());
            
            preparedStatement.setString(2,message.getDestination());
            
            preparedStatement.setString(3, message.getObjet());
            
            preparedStatement.setString(4, message.getContenu());
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
		
		
	}



	public List<Message> reccuperer_messages_envoyes(String matricule) {
		

	    ArrayList<Message> messages = new ArrayList<Message>();

        ResultSet resultat = null;


        loadDatabase();

       

        try {

            // Exécution de la requête
        	
        	 PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM Message where source = ?;");

             preparedStatement.setString(1, matricule);
             
             resultat = preparedStatement.executeQuery();

         
            // Récupération des données

            while (resultat.next()) {
            	
            	int id = resultat.getInt("id");

                String source = resultat.getString("source");

                String destination = resultat.getString("destination");
         
                String objet = resultat.getString("objet") ;
                
                String contenu = resultat.getString("contenu") ;
                
                Date date = resultat.getDate("date") ;
                
                String etat = resultat.getString("etat") ;
                
                
                Message message = new Message() ;
                
                message.setId(id);
                
                message.setSource(source);
                
                message.setDestination(destination);
                
                message.setObjet(objet);
                
                message.setContenu(contenu);
                
                message.setDate(date);
                
                message.setEtat(etat);
                


                
              messages.add(message) ;
            }

        } catch (SQLException e) {

        } finally {

            // Fermeture de la connexion

            try {

                if (resultat != null)

                    resultat.close();

                if (connexion != null)

                    connexion.close();

            } catch (SQLException ignore) {

            }

        }

        

        return messages;
	
	
	}



	public String getMatricule(String login, String password) {
		
		String matricule = "";
        loadDatabase();
        ResultSet resultat = null;
           

        try {

            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT matricule FROM noms WHERE login= ? and password= ?;");

            preparedStatement.setString(1, login);
            
            preparedStatement.setString(2, password);

            resultat = preparedStatement.executeQuery();
            
            if (resultat.next()) {
               matricule = resultat.getString("matricule"); 
            }
          
            

        } catch (SQLException e) {

            e.printStackTrace();

        }
        
      
		return matricule;

		
	
	}



	public void add_salaire(Salary salary) {
			
	loadDatabase();
	       
	
	        
	
	        try {
	
	            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO salaire (matricule, nb_heures, nb_extra, prime, impots, date) values (? , ?, ?, ?, ?, ?);");
	
	            preparedStatement.setString(1, salary.getMatricule());
	
	            preparedStatement.setFloat(2, salary.getNb_heures());
	            
	            preparedStatement.setFloat(3, salary.getNb_extra());
	            
	            preparedStatement.setFloat(4, salary.getPrime());
	            
	            preparedStatement.setFloat(5, salary.getImpots());
	            
	            java.sql.Date sqlDate = new java.sql.Date(salary.getDate().getTime()) ;
	            	            
	            preparedStatement.setDate(6, sqlDate);
	           
	            preparedStatement.executeUpdate();
	
	        } catch (SQLException e) {
	
	            e.printStackTrace();
	
	        }
			
		}



	public float[] reccupperer_h_paie(String matricule) {
		   
		    float[] h_paie = new float[]{ 0,0 };

	        ResultSet resultat = null;

	        loadDatabase();

	       

	        try {


	            // Exécution de la requête

	           PreparedStatement preparedStatement = connexion.prepareStatement("SELECT paie_heure, pex_heure FROM noms where matricule= ?;");

	           preparedStatement.setString(1, matricule);

	           resultat = preparedStatement.executeQuery();

	            // Récupération des données

	            while (resultat.next()) {

	                float paie_heure = resultat.getFloat("paie_heure");
	                
	                float pex_heure = resultat.getFloat("pex_heure");
	                
	                h_paie[0] = paie_heure ;
	                
	                h_paie[1] = pex_heure;
	                
	                
	            }

	        } catch (SQLException e) {

	        } finally {

	            // Fermeture de la connexion

	            try {

	                if (resultat != null)

	                    resultat.close();

	                if (connexion != null)

	                    connexion.close();

	            } catch (SQLException ignore) {

	            }

	        }

	        

	        return h_paie;
		
	}



	public int get_last_salary(String matricule) {
		   int id = 0 ;
			
	        loadDatabase();
	        
	        ResultSet resultat = null;
	           

	        try {
	        	
	            // Exécution de la requête

	        	PreparedStatement preparedStatement = connexion.prepareStatement("SELECT Max(id) FROM salaire where matricule= ?;");
	            
	        	preparedStatement.setString(1, matricule);

		        resultat = preparedStatement.executeQuery();
	        	
	            if (resultat.next()) {
	               id = resultat.getInt(1) ;
	            }
	          
	            

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
	        
	      		
			return id;
		
	}



	public List<Pointage> reccupperer_pts(String matricule, Date date_debM, Date date_finM) {
		
		ArrayList<Pointage> pts = new ArrayList<Pointage>();
		 
        ResultSet resultat = null;


        loadDatabase();

       

        try {

            // Exécution de la requête

            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM pointage where matricule= ? and date >= ? and date <= ? ;");

            preparedStatement.setString(1, matricule);
            
            java.sql.Date sqlDate = new java.sql.Date(date_debM.getTime()) ;
            
            preparedStatement.setDate(2, sqlDate);
            
            sqlDate = new java.sql.Date(date_finM.getTime()) ;
            
            preparedStatement.setDate(3, sqlDate);

            resultat = preparedStatement.executeQuery();
            
            // Récupération des données

            while (resultat.next()) {
            	
            	Date date = resultat.getTime("date") ;
            	
                String type = resultat.getString("type") ;

                Pointage pt = new Pointage() ;
                
                pt.setMatricule(matricule);
                
                pt.setDate(date);
                
                pt.setType(type);
                
                pts.add(pt) ;
                
            }

        } catch (SQLException e) {

        } finally {

            // Fermeture de la connexion

            try {

                if (resultat != null)

                    resultat.close();


                if (connexion != null)

                    connexion.close();

            } catch (SQLException ignore) {

            }

        }

        

        return pts;
	
	
	
	}



	public List<Formation> recupperer_de_formations(String etat) {
		
		List<Formation> formations = new ArrayList<Formation>() ;

        Statement statement = null;

        ResultSet resultat = null;


        loadDatabase();

       

        try {

           // Exécution de la requête

            PreparedStatement preparedStatement = connexion.prepareStatement("SELECT id, service, theme, priorite, dure_moy, budget, date_debut, date_fin, lieu  FROM formation where etat= ?;");

            preparedStatement.setString(1, etat);

            resultat = preparedStatement.executeQuery();

            // Récupération des données

            while (resultat.next()) {
            	
            	int id = resultat.getInt("id");
            	
                String service = resultat.getString("service");

                String theme = resultat.getString("theme");
                
                int priorite = resultat.getInt("priorite");

                int dure_moy = resultat.getInt("dure_moy");
                
                float budget = resultat.getFloat("budget");
                
                Date date_debut = resultat.getDate("date_debut") ;
                
                Date date_fin = resultat.getDate("date_fin") ;
                
                String lieu = resultat.getString("lieu") ;
                
                

                Formation formation = new Formation() ;
                
                formation.setId(id);

                formation.setService(service);
                
                formation.setTheme(theme);
                
                formation.setPriorite(priorite);
                
                formation.setDure_moy(dure_moy);
                
                formation.setBudget(budget);
                
                formation.setDate_debut(date_debut);
                
                formation.setDate_fin(date_fin);
                
                formation.setLieu(lieu);
                
                formation.setEtat(etat);
                
                formations.add(formation);
                
            }

        } catch (SQLException e) {

        } finally {

            // Fermeture de la connexion

            try {

                if (resultat != null)

                    resultat.close();

                if (statement != null)

                    statement.close();

                if (connexion != null)

                    connexion.close();

            } catch (SQLException ignore) {

            }

        }

        

        return formations;

		
	
	}



	public List<Salary> reccupperer_salaires(String matricule) {
		
		    ArrayList<Salary> salaires = new ArrayList<Salary>();

	        ResultSet resultat = null;


	        loadDatabase();

	       

	        try {


	            // Exécution de la requête

	           PreparedStatement preparedStatement = connexion.prepareStatement("SELECT id, nb_heures, nb_extra, prime, impots, date FROM salaire where matricule= ?;");

	           preparedStatement.setString(1, matricule);

	           resultat = preparedStatement.executeQuery();

	            // Récupération des données

	            while (resultat.next()) {

	                int id = resultat.getInt("id");

	                float nb_heures = resultat.getFloat("nb_heures");
	                
	                float nb_extra = resultat.getFloat("nb_extra");
	                
	                float prime = resultat.getFloat("prime");
	                
	                float impots = resultat.getFloat("impots");
	                
	                Date date = resultat.getDate("date");
	                
	                Salary salaire = new Salary() ;

	                salaire.setId(id);
	                
	                salaire.setMatricule(matricule);
	                
	                salaire.setNb_heures(nb_heures);
	                
	                salaire.setNb_extra(nb_extra);
	                
	                salaire.setPrime(prime);
	                
	                salaire.setImpots(impots);
	                
	                salaire.setDate(date);
	                
	                salaires.add(salaire);
	            }
	            

	        } catch (SQLException e) {

	        } finally {

	            // Fermeture de la connexion

	            try {

	                if (resultat != null)

	                    resultat.close();

	                if (connexion != null)

	                    connexion.close();

	            } catch (SQLException ignore) {

	            }

	        }

	        

	        return salaires;

		
	}



	public void add_candidature(int id_offre, String nomFichier, String position) {
	 
			
		       loadDatabase();
		       
		        try {

		            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO candidature (id_offre, nomFichier, position) VALUES ( ?, ?, ?);");

		            preparedStatement.setInt(1, id_offre);
		            
		            preparedStatement.setString(2, nomFichier);
		            
		            preparedStatement.setString(3, position);
		           
		            preparedStatement.executeUpdate();

		        } catch (SQLException e) {

		            e.printStackTrace();

		        }
				
				
		
	}



	public List<Candidat> reccupperer_Candidats() {
		
		ArrayList<Candidat> candidats = new ArrayList<Candidat>();
		 
        Statement statement = null;

        ResultSet resultat = null;


        loadDatabase();

       

        try {

            statement = connexion.createStatement();

            // Exécution de la requête

            resultat = statement.executeQuery("SELECT * FROM candidature;");


            // Récupération des données

            while (resultat.next()) {
            	
            	int id_candidature = resultat.getInt("id_candidature");

                int id_offre = resultat.getInt("id_offre");
                
                String position = resultat.getString("position") ;

                String nomFichier = resultat.getString("nomFichier");
                
                
               Candidat candidat = new Candidat() ;
                
                candidat.setId_candidature(id_candidature);
                
                candidat.setId_offre(id_offre);
                
                candidat.setPosition(position);
               
                candidat.setNomFichier(nomFichier);
                
                candidats.add(candidat);

            }

        } catch (SQLException e) {

        } finally {

            // Fermeture de la connexion

            try {

                if (resultat != null)

                    resultat.close();

                if (statement != null)

                    statement.close();

                if (connexion != null)

                    connexion.close();

            } catch (SQLException ignore) {

            }

        }

        

        return candidats;
	
	
	
		
	}



	public void update_etat_recrutement(int id,String etat) {
		
		loadDatabase();
		 
		 try {

	            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE recrutement SET etat= ? WHERE id= ?;" );

	            preparedStatement.setString(1, etat);
	            
	            preparedStatement.setInt(2, id);
	            
	            preparedStatement.executeUpdate() ;
	            
	     
	                  

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
	        
		
		// TODO Auto-generated method stub
		
		
	
		
	}



	public void update_offre(Offre offre) {
		
		loadDatabase();
		 
		 try {

	            PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE offre_emploi SET position= ?, competences= ?, description= ?, experience= ?, date_pub= ?, date_limite= ? WHERE id= ?;" );

	            preparedStatement.setString(1, offre.getPosition());
	            
	            preparedStatement.setString(2, offre.getCompetences());
	            
	            preparedStatement.setString(3, offre.getDescription());
	            
	            preparedStatement.setInt(4, offre.getExperience());
	            
                java.sql.Date sqlDate = new java.sql.Date(offre.getDate_pub().getTime()) ;
	            
	            preparedStatement.setDate(5, sqlDate);
	            
                sqlDate = new java.sql.Date(offre.getDate_limite().getTime()) ;
	            
	            preparedStatement.setDate(6, sqlDate);
	             
	            preparedStatement.setInt(7, offre.getId());
	            
	            preparedStatement.executeUpdate() ;
	            
	     
	                  

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
	        
		
		
		
	}






}