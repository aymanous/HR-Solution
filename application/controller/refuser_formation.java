package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;

/**
 * Servlet implementation class refuser_formation
 */
@WebServlet("/refuser_formation")
public class refuser_formation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public refuser_formation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  Noms noms = new Noms() ;
		
		  int id = Integer.parseInt(request.getParameter("id"));
		  
		  int indice = Integer.parseInt(request.getParameter("indice"));
		  
		  if (indice == 1){
			  
			  noms.update_etat_formation(id,"canceled") ;
			  
			  this.getServletContext().getRequestDispatcher("/Liste_formations").forward(request, response);
		  }   
		                  
		  if (indice == 2){
			  
			  noms.update_etat_formation(id,"refused") ; 
			  
			  this.getServletContext().getRequestDispatcher("/liste_demande_formation").forward(request, response);
		  }  
		  
          if (indice == 3){
			  
			  noms.update_etat_formation(id,"accepted") ; 
			  
			  this.getServletContext().getRequestDispatcher("/liste_demande_formation").forward(request, response);
		  }  
		 
         if (indice == 4){
			  
			  noms.update_etat_formation(id,"accepted") ; 
			  
			  this.getServletContext().getRequestDispatcher("/Liste_formations").forward(request, response);
		  }  
         
         if (indice == 5){
			  
			  noms.update_etat_recrutement(id,"refused") ; 
			  
			  this.getServletContext().getRequestDispatcher("/Consulter_d_recrutement").forward(request, response);
		  }  
		 
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
