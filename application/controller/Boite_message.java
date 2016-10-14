package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Message;

/**
 * Servlet implementation class Boite_message
 */
@WebServlet("/Boite_message")
public class Boite_message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Boite_message() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Noms noms = new Noms() ;
		
	 	String matricule = request.getParameter("matricule") ;
	 	
	 	List<Message> messages = noms.reccupperer_messages(matricule);
	 	
	 	request.setAttribute("messages", messages);
				
		String position = noms.getPosition(matricule) ;
		
		 if(position.equals("Administrateur")){
			 this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/Boite_admin.jsp").forward(request, response);
	        }
	        else if (position.equals("Chef service"))
	        	this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/Boite_chef.jsp").forward(request, response);
	        else
	        	this.getServletContext().getRequestDispatcher("/WEB-INF/Employe/Boite_employe.jsp").forward(request, response);
	       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
