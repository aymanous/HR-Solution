package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Utilisateur;

/**
 * Servlet implementation class Employe_Infos
 */
@WebServlet("/Employe_Infos")
public class Employe_Infos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employe_Infos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Noms noms = new Noms();
		 
		 Utilisateur utilisateur = noms.recupererUtilisateur(request.getParameter("matricule"));
		 
		 request.setAttribute("utilisateur", utilisateur);
		 
		 if (utilisateur.getPosition().equals("Chef Executif"))
		 
			 this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/chef_service_info.jsp").forward(request, response);    
		 
		 else  this.getServletContext().getRequestDispatcher("/WEB-INF/Employe/Employe_Info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
