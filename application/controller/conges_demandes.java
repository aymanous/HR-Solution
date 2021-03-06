package com.sdzee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Conge;

/**
 * Servlet implementation class conges_demandes
 */
@WebServlet("/conges_demandes")
public class conges_demandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public conges_demandes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Noms noms = new Noms();
			
	  	 List<Conge> conges = noms.recupperer_conges();
		
		 ArrayList<Conge> conges_demandes = new ArrayList<Conge>();
		 
		
			//get current date time with Date()
		    Date date1 = new Date();
		    	    
		    Date date2 = new Date() ;
		    	
		    int diff_date = 0 ;
		    	    
		    for(int i = 0 ; i < conges.size() ; i++ ){
		    	
		        date2 = conges.get(i).getDatedeb() ;
		        
		        diff_date = (int)( (date1.getTime() - date2.getTime())  / (1000 * 60 * 60 * 24) ) ;
		         
		       	
		   
		       	if ( diff_date <= 0 ){ 	
		       		conges_demandes.add(conges.get(i)) ; 
		    }		
		     
		    }
		       	
		   	
			request.setAttribute("conges", conges_demandes);
				
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/Conges_demandes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
