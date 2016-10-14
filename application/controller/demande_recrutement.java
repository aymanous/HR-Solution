package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Recrutement;

/**
 * Servlet implementation class demande_recrutement
 */
@WebServlet("/demande_recrutement")
public class demande_recrutement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demande_recrutement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Noms noms = new Noms() ;
			
		request.setAttribute("service", noms.getService(request.getParameter("matricule")));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/demande_recrutement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Noms noms = new Noms() ;
		
		Recrutement recrutement = new Recrutement() ;
		
		recrutement.setService(request.getParameter("service"));
		
		recrutement.setPosition(request.getParameter("position"));
		
		recrutement.setCompetences(request.getParameter("competences"));
		
		recrutement.setExperience(Integer.parseInt(request.getParameter("experience")));
		
		noms.add_demande_recrutement(recrutement) ;

		this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/demande_recrutement.jsp").forward(request, response);
	}

}
