package com.sdzee.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Utilisateur;

/**
 * Servlet implementation class Ajouter_Employe
 */
@WebServlet("/Ajouter_Employe")
public class Ajouter_Employe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter_Employe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/Ajouter_Employe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = new Utilisateur();

        utilisateur.setMatricule(request.getParameter("matricule"));
        
        utilisateur.setLogin(request.getParameter("login"));

        utilisateur.setPassword(request.getParameter("password"));
        
        utilisateur.setNom(request.getParameter("nom"));
        
        utilisateur.setPrenom(request.getParameter("prenom"));
        
        utilisateur.setPosition(request.getParameter("position"));
        
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		format.setLenient(false);
		
		String d = request.getParameter("deb_contrat") ;
		
		Date date = new Date();
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        utilisateur.setDeb_contrat(date);
        
        d = request.getParameter("fin_contrat") ;
        
        try {
			date = format.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        utilisateur.setFin_contrat(date);
        
        utilisateur.setEmail(request.getParameter("email"));
        
        utilisateur.setPhone(request.getParameter("phone"));
        
        utilisateur.setService(request.getParameter("service"));
        
        utilisateur.setPaie_heure(Float.parseFloat(request.getParameter("paie_heure")));
        
        utilisateur.setPex_heure(Float.parseFloat(request.getParameter("pex_heure")));
        
        utilisateur.setVille(request.getParameter("ville"));
        
        utilisateur.setAdresse(request.getParameter("adresse"));
        
        utilisateur.setPays(request.getParameter("pays"));
        
        
        Noms noms = new Noms();
        
        noms.Ajouter_Employe(utilisateur) ; 
	
        this.getServletContext().getRequestDispatcher("/Infos").forward(request, response);
	}

}
