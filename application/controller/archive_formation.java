package com.sdzee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Formation;

/**
 * Servlet implementation class archive_formation
 */
@WebServlet("/archive_formation")
public class archive_formation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public archive_formation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         Noms noms = new Noms();
	     
	     List<Formation> formations = noms.recupperer_de_formations();
	     
	     List<Formation> de_formations = new ArrayList<Formation>() ;
	     
         for(int i = 0 ; i < formations.size() ; i++){
	    	 
	    	 if(formations.get(i).getEtat().equals("archive"))
	    		 
	    		  de_formations.add(formations.get(i)) ;
	     }
	     
	     request.setAttribute("formations", de_formations);
	     
		 this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/archive_formation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
