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
 * Servlet implementation class Employe_Conge
 */
@WebServlet("/Employe_Conge")
public class Employe_Conge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employe_Conge() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
 
		String matricule = request.getParameter("matricule") ;
		
		Noms noms = new Noms();
				
		List<Integer> T = new ArrayList<Integer>();
		
		List<Conge> conges = noms.recupperer_Employe_Conges(matricule);
		
	    ArrayList<Conge> conges_courantes = new ArrayList<Conge>();
		
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
		request.setAttribute("conges_courants", conges_courantes);
		
		String position = noms.getPosition(matricule) ;
		
		if (position.equals("Chef Executif"))  
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/chef_service_conges.jsp").forward(request, response);
		
		else this.getServletContext().getRequestDispatcher("/WEB-INF/Employe/Employe_Conge.jsp").forward(request, response);
		}
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
       doGet(request,response);

   }
}