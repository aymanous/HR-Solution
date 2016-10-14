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
 * Servlet implementation class conges_courants
 */
@WebServlet("/conges_courants")
public class conges_courants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public conges_courants() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	     Noms noms = new Noms();
		
	  	 List<Conge> conges = noms.recupperer_conges();
		
		 ArrayList<Conge> conges_courantes = new ArrayList<Conge>();
		 
		 List<Integer> T = new ArrayList<Integer>();
			
			
			//get current date time with Date()
		    Date date1 = new Date();
		    	    
		    Date date2 = new Date() ;
		    
		    int diffInDays = 0 ;
			
		    int diff_date = 0 ;
		    	    
		    for(int i = 0 ; i < conges.size() ; i++ ){
		    	
		        date2 = conges.get(i).getDatedeb() ;
		        
		        diff_date = (int)( (date1.getTime() - date2.getTime())  / (1000 * 60 * 60 * 24) ) ;
		         
		       	diffInDays = conges.get(i).getJours_demande() - diff_date ;
		       	
		       
		       	if ( diff_date >= 0 ){
		       	
		          	if( diffInDays >= 0 && conges.get(i).getReponse().equals("accepted") ) { T.add(diffInDays) ; conges_courantes.add(conges.get(i)) ;} 
	             
		       	}		
		     
		    }
		       	
		    
		 
		    request.setAttribute("diff_days", T);		
			request.setAttribute("conges", conges_courantes);
				
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/Conges_Employe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
