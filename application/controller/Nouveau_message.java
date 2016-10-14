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
 * Servlet implementation class Nouveau_message
 */
@WebServlet("/Nouveau_message")
public class Nouveau_message extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nouveau_message() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/Nouveau_message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 	Noms noms = new Noms();
		
	    Message message = new Message() ;
	    
	 	message.setSource(request.getParameter("source"));
	 	
	 	message.setDestination(request.getParameter("destination"));
	 	
	 	message.setObjet(request.getParameter("objet"));
	 	
	 	message.setContenu(request.getParameter("contenu"));
	 	
	 	noms.add_message(message) ;
	 	
        List<Message> messages = noms.reccupperer_messages(request.getParameter("source"));
	 	
	 	request.setAttribute("messages", messages);
				
		String position = noms.getPosition(request.getParameter("source")) ;
		
		 if(position.equals("Administrateur")){
			 this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/Boite_admin.jsp").forward(request, response);
	        }
	        else if (position.equals("Chef service"))
	        	this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/Boite_chef.jsp").forward(request, response);
	        else
	        	this.getServletContext().getRequestDispatcher("/WEB-INF/Employe/Boite_employe.jsp").forward(request, response); 
	}

}
