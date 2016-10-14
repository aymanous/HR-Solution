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
 * Servlet implementation class archive_conges
 */
@WebServlet("/archive_conges")
public class archive_conges extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public archive_conges() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String matricule = request.getParameter("matricule") ;
        
		Noms noms = new Noms();
		
		List<Conge> conges = noms.recupperer_Employe_Conges(matricule);
		
		ArrayList<Conge> archive = new ArrayList<Conge>();
		
		//get current date time with Date()
	    Date date1 = new Date();
	    
        Date date2  ;
	    
	    int diffInDays = 0 ;
		
	    int diff_date = 0 ;
		
		 for(int i = 0 ; i < conges.size() ; i++ ){
			 
			 date2 = conges.get(i).getDatedeb() ;
		        
		     diff_date = (int)( (date1.getTime() - date2.getTime())  / (1000 * 60 * 60 * 24) ) ;
		    
		     diffInDays = conges.get(i).getJours_demande() - diff_date ;
			 
			if( diffInDays < 0 && conges.get(i).getReponse().equals("accepted"))
				   archive.add(conges.get(i)) ;
		 } 
		
		
		
		request.setAttribute("archive", archive);
		

		String position = noms.getPosition(matricule) ;
		
		if (position.equals("Chef Executif"))  
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/chef_service_archive.jsp").forward(request, response);
		
		else  this.getServletContext().getRequestDispatcher("/WEB-INF/Employe/Employe_Archive.jsp").forward(request, response);
		 
	   }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
