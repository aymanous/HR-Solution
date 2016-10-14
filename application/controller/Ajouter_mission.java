package com.sdzee.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Mission;
import com.octest.beans.Utilisateur;

/**
 * Servlet implementation class Ajouter_mission
 */
@WebServlet("/Ajouter_mission")
public class Ajouter_mission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_mission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		 Noms noms = new Noms() ;
		
		 String service = noms.getService(request.getParameter("matricule")) ;
		
		 request.setAttribute("service", service);
		
		 List<Utilisateur> utilisateurs = noms.recupererEquipe(service);
			 
		 request.setAttribute("utilisateurs", utilisateurs);
		
		 request.setAttribute("service", service);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/Ajouter_mission.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Noms noms = new Noms() ;
		
		Mission mission = new Mission() ;
	
		mission.setService(request.getParameter("service"));
		
		mission.setObjet(request.getParameter("objet"));
		
		mission.setDescription(request.getParameter("description"));
		
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		format.setLenient(false);
		
		String d = request.getParameter("date_debut") ;
		
		Date date = new Date();
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		mission.setDate_debut(date);
		
		mission.setDure(Integer.parseInt(request.getParameter("dure")));
		
		mission.setLieu(request.getParameter("lieu"));
		
		noms.add_mission(mission) ;
		
        String service = noms.getService(request.getParameter("matricule")) ;
		
		List<Mission> missions = noms.reccupperer_missions(service) ;
		
		request.setAttribute("missions", missions);
		
        String [] designes = request.getParameterValues("designes") ;
	    
	    int id = noms.getId_mission()  ;
		
	    for(int i = 0 ; i< designes.length ;i++){
	    	
	    	noms.add_employe_mission(designes[i] , id);
	    }
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/afficher_missions.jsp").forward(request, response);
	}

}
