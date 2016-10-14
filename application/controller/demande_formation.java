package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Formation;
import com.octest.beans.Utilisateur;



/**
 * Servlet implementation class demande_formation
 */
@WebServlet("/demande_formation")
public class demande_formation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demande_formation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  Noms noms = new Noms();	
	 	  
		  String service = noms.getService((String)request.getParameter("matricule")) ;
			 
		  List<Utilisateur> utilisateurs = noms.recupererEquipe(service);
			 
		  request.setAttribute("utilisateurs", utilisateurs);
		
		  request.setAttribute("service", service);
		
	 this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/demande_formation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        Noms noms = new Noms() ;
		
		Formation formation = new Formation() ;
		
		formation.setService(request.getParameter("service"));
		
		formation.setTheme(request.getParameter("theme"));
				
		formation.setPriorite(Integer.parseInt(request.getParameter("priorite")));
		
		formation.setDure_moy(Integer.parseInt(request.getParameter("dure_moy")));
		
		noms.add_formation(formation) ;
						
	    String [] designes = request.getParameterValues("designes") ;
	    
	    int id = noms.getId_formation()  ;
		
	    for(int i = 0 ; i< designes.length ;i++){
	    	
	    	noms.add_designe(designes[i] , id);
	    }
		
		request.setAttribute("matricule", request.getParameter("matricule"));
		
		this.getServletContext().getRequestDispatcher("/chef_d_formations").forward(request, response);
	}

}
