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
 * Servlet implementation class Modifier_Fiche
 */
@WebServlet("/Modifier_Fiche")
public class Modifier_Fiche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_Fiche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/Modifier_Fiche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Noms noms = new Noms();
		
		Salary salary = new Salary();
		
		String matricule = request.getParameter("matricule") ;

        int id = noms.get_last_salary(matricule) ;
        
        salary.setId(id);
        
        salary.setPrime(Float.parseFloat(request.getParameter("prime")));
        
        salary.setImpots(Float.parseFloat(request.getParameter("impots")));
        
        noms.Update_salaire(salary) ;
        
        request.setAttribute("matricule", matricule);
        
		this.getServletContext().getRequestDispatcher("/Prime").forward(request, response);
	}

}
