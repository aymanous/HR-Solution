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
 * Servlet implementation class Employe_Fiche
 */
@WebServlet("/Employe_Fiche")
public class Employe_Fiche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employe_Fiche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Noms noms = new Noms();
		
		String matricule = request.getParameter("matricule") ;
		 
		int id = noms.get_last_salary(matricule);
		
		Salary salary = noms.recupperer_salaire(id);
		 
		request.setAttribute("salaire", salary);
		 
		float[] h_paie = new float[]{ 0,0 };
			
	    h_paie =  noms.reccupperer_h_paie(matricule) ;
	    	
	    request.setAttribute("paie_heure", h_paie[0]);
		
	    request.setAttribute("pex_heure", h_paie[1]);
		 
		 
		 
		 if (noms.getPosition(matricule).equals("Chef Executif"))
		 
		    this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/chef_service_fiche.jsp").forward(request, response);
		 
		 else this.getServletContext().getRequestDispatcher("/WEB-INF/Employe/Employe_Fiche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
