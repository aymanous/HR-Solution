package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Utilisateur;

/**
 * Servlet implementation class equipe
 */
@WebServlet("/equipe")
public class equipe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public equipe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 Noms noms = new Noms();
		 
	  	 String service = noms.getService(request.getParameter("matricule")) ;
		 
		 List<Utilisateur> utilisateurs = noms.recupererEquipe(service);
		 
		 request.setAttribute("utilisateurs", utilisateurs);
		 
		this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/equipe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
	  doGet(request,response);
	}
}
