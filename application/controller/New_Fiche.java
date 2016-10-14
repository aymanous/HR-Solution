package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Salary;

/**
 * Servlet implementation class New_Fiche
 */
@WebServlet("/New_Fiche")
public class New_Fiche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New_Fiche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/New_Fiche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Salary salary = new Salary();

        salary.setMatricule(request.getParameter("matricule"));
        
        salary.setSalaire_base(request.getParameter("salaire_base"));
        
        salary.setPrime_rendement(request.getParameter("prime_rendement"));
        
        salary.setPrime_presence(request.getParameter("prime_presence"));
        
        salary.setFrais_professionnels(request.getParameter("frais_professionnels"));
        
        salary.setSecurite_sociale(request.getParameter("securite_sociale"));
                
        salary.setRetraite_complementaire(request.getParameter("retraite_complementaire"));
        
        salary.setAutres_impots(request.getParameter("autres_impots"));
        
        Noms noms = new Noms();
        
        noms.add_prime(salary) ;
       
		salary = noms.recupperer_prime(request.getParameter("matricule")) ;
		
		request.setAttribute("salary", salary);	
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/Prime_Fiche.jsp").forward(request, response);	
	}

}
