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
import com.octest.beans.Formation;

/**
 * Servlet implementation class liste_demande_formation
 */
@WebServlet("/liste_demande_formation")
public class liste_demande_formation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public liste_demande_formation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Noms noms = new Noms();
	     
        List<Formation> L_formations = new ArrayList<Formation>() ;
    
        List<Formation> formations = noms.recupperer_formations();
    
        Date date1 = new Date();
       
        int diff_date1 = 0  ;
     
        for(int i = 0 ; i < formations.size() ; i++){
   
          if( formations.get(i).getEtat().equals("In progress") || formations.get(i).getEtat().equals("canceled") || formations.get(i).getEtat().equals("Archive"))  continue ;
         
   	        diff_date1 = (int)( (date1.getTime() - formations.get(i).getDate_debut().getTime())  / (1000 * 60 * 60 * 24) ) ;
   	 
   	        if(diff_date1 <= 0 )  L_formations.add(formations.get(i)) ;
   	     	  
   	    }
        
        request.setAttribute("formations", L_formations);
	     
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/liste_demande_formation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
