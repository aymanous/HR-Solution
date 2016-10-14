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
import com.octest.beans.Mission;

/**
 * Servlet implementation class Employe_missions
 */
@WebServlet("/Employe_missions")
public class Employe_missions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employe_missions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

           Noms noms = new Noms();
		 
		   List<Mission> missions = new ArrayList<Mission>() ;
	
		   List<Integer> ids = noms.recupperer_employe_missions(request.getParameter("matricule"));
		 
		   Mission mission = new Mission() ;
		 
		   for(int i = 0; i<ids.size() ; i++){
		 
		     mission = noms.recupperer_info_mission(ids.get(i)) ;
		 
		     missions.add(mission) ;
		
		  }
		 
		 request.setAttribute("missions", missions);
		 
		 this.getServletContext().getRequestDispatcher("/WEB-INF/Employe/Employe_missions.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
