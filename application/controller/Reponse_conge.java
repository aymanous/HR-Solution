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
 * Servlet implementation class Reponse_conge
 */
@WebServlet("/Reponse_conge")
public class Reponse_conge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reponse_conge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        Conge conge = new Conge();
		
        conge.setReponse(request.getParameter("reponse")); 

        conge.setMatricule(request.getParameter("matricule"));

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

        Noms noms = new Noms();

        noms.update_conge(conge);

        this.getServletContext().getRequestDispatcher("/conges_demandes").forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
