package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;


/**
 * Servlet implementation class supprimer_mission
 */
@WebServlet("/supprimer_mission")
public class supprimer_mission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public supprimer_mission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/Supprimer_mission.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Noms noms = new Noms();
		
		int id = Integer.parseInt(request.getParameter("id")) ;
        
		noms.supprimer_employe_missions(id) ;
		
        noms.Supprimer_mission(id) ;
        
        request.setAttribute("matricule", request.getParameter("matricule"));
        
        this.getServletContext().getRequestDispatcher("/Missions").forward(request, response);

}

}