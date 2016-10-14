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
 * Servlet implementation class Liste_formations
 */
@WebServlet("/Liste_formations")
public class Liste_formations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liste_formations() {
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
	        
	         int diff_date1 = 0 , diff_date2 = 0 ;
	      
	         for(int i = 0 ; i < formations.size() ; i++){
	    
	         if( formations.get(i).getEtat().equals("requested") || formations.get(i).getEtat().equals("refused") || formations.get(i).getEtat().equals("canceled"))  continue ;
	          
	    	 diff_date1 = (int)( (date1.getTime() - formations.get(i).getDate_debut().getTime())  / (1000 * 60 * 60 * 24) ) ;
	    	 
	    	 diff_date2 = (int)( (date1.getTime() - formations.get(i).getDate_fin().getTime())  / (1000 * 60 * 60 * 24) ) ;
	    	 
	    	 if( diff_date1 >= 0 && diff_date2 <=0 )   noms.update_etat_formation(formations.get(i).getId(),"In progress");
	    	 
	    	 if(diff_date2 > 0 )  noms.update_etat_formation(formations.get(i).getId(),"Archive");
	    	     	  
	    	 }
	         
	         formations = noms.recupperer_formations();
	         
	         for(int i = 0 ; i < formations.size() ; i++){
	     	    
		         if(formations.get(i).getEtat().equals("requested") || formations.get(i).getEtat().equals("refused") || formations.get(i).getEtat().equals("Archive")  || formations.get(i).getEtat().equals("accepted")) continue ;
	          
	             L_formations.add(formations.get(i)) ;
	    	    
	         }
		         
	     
	     
	     request.setAttribute("formations", L_formations);
	     
		 this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/afficher_formations.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

} 
