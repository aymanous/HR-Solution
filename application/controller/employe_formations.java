package com.sdzee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Formation;

/**
 * Servlet implementation class employe_formations
 */
@WebServlet("/employe_formations")
public class employe_formations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employe_formations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		 Noms noms = new Noms();
		 
		 List<Formation> formations = new ArrayList<Formation>() ;
	
		 List<Integer> ids = noms.recupperer_employe_formations(request.getParameter("matricule"));
		 
		 Formation formation = new Formation() ;
		 
		 for(int i = 0; i<ids.size() ; i++){
		 
		     formation = noms.recupperer_info_formation(ids.get(i)) ;
		 
		     formations.add(formation) ;
		
		  }
		 
		 request.setAttribute("formations", formations);
		 
		 this.getServletContext().getRequestDispatcher("/WEB-INF/Employe/afficher_formations.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
