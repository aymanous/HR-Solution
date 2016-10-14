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
 * Servlet implementation class Modifier_donnees
 */
@WebServlet("/Modifier_donnees")
public class Modifier_donnees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_donnees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur utilisateur = new Utilisateur();
		
		String matricule = request.getParameter("matricule") ;

        utilisateur.setMatricule(matricule);
        
        utilisateur.setLogin(request.getParameter("login"));

        utilisateur.setPassword(request.getParameter("password"));
        
        utilisateur.setNom(request.getParameter("nom"));
        
        utilisateur.setPrenom(request.getParameter("prenom")); 
       
        utilisateur.setEmail(request.getParameter("email"));
        
        utilisateur.setPhone(request.getParameter("phone"));
        
        utilisateur.setVille(request.getParameter("ville"));
        
        utilisateur.setAdresse(request.getParameter("adresse"));
        
        utilisateur.setPays(request.getParameter("pays"));
        
        
         Noms noms = new Noms();
        
         /*   noms.Mise_A_Jour(utilisateur) ; */
        String position = noms.getPosition(matricule) ;
		
		if (position.equals("Chef Executif"))  
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Authentification/Chef_Service.jsp").forward(request, response);
		
		else this.getServletContext().getRequestDispatcher("/WEB-INF/Authentification/Employe.jsp").forward(request, response);
		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
