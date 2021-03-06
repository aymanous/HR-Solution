package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Salary;

/**
 * Servlet implementation class archive_salaire_employe
 */
@WebServlet("/archive_salaire_employe")
public class archive_salaire_employe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public archive_salaire_employe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		Noms noms = new Noms() ;
		
		String matricule = request.getParameter("matricule") ;
				
		List<Salary> salaires = noms.reccupperer_salaires(matricule);
		
        float[] h_paie = new float[]{ 0,0 };
		
    	h_paie =  noms.reccupperer_h_paie(matricule) ;
    		
    	request.setAttribute("paie_heure", h_paie[0]);
	
    	request.setAttribute("pex_heure", h_paie[1]);
		
		request.setAttribute("salaires", salaires);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/archive_salaire.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
