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
import com.octest.beans.Conge;

/**
 * Servlet implementation class Demande_Conge
 */
@WebServlet("/Demande_Conge")
public class Demande_Conge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demande_Conge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Noms noms = new Noms();
		
	    String matricule = request.getParameter("matricule") ;
		
        String position = noms.getPosition(matricule);
		
		if(position.equals("Chef Executif"))   
		
		   this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/chef_demande_conge.jsp").forward(request, response);
		
		else this.getServletContext().getRequestDispatcher("/WEB-INF/Employe/Employe_Demande_Conge.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Conge conge = new Conge() ;
		
		String matricule= request.getParameter("matricule") ;
		
		conge.setMatricule(matricule);
	
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		format.setLenient(false);
		
		String d = request.getParameter("datedeb") ;
		
		Date date = new Date();
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conge.setDatedeb(date);
		
		conge.setJours_demande(Integer.parseInt(request.getParameter("jours_demande")));
		
		conge.setType_conge(request.getParameter("type_conge"));
			
		Noms noms = new Noms();
		
		noms.add_conge(conge); 
					
		String position = noms.getPosition(matricule) ;
		
		request.setAttribute("matricule", matricule);
		
		if(position.equals("Chef Executif"))   
			
			   this.getServletContext().getRequestDispatcher("/demandes_conges").forward(request, response);
			
			else this.getServletContext().getRequestDispatcher("/demandes_conges").forward(request, response);
			
		}


}
