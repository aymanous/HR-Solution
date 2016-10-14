package com.sdzee.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Mission;

/**
 * Servlet implementation class Modifier_mission
 */
@WebServlet("/Modifier_mission")
public class Modifier_mission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_mission() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/chef_service/Modifier_mission.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
	    Noms noms = new Noms() ;
		
		Mission mission = new Mission() ;
		
		mission.setId(Integer.parseInt(request.getParameter("id")));
	
		mission.setService(request.getParameter("service"));
		
		mission.setObjet(request.getParameter("objet"));
		
		mission.setDescription(request.getParameter("description"));
		
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		format.setLenient(false);
		
		String d = request.getParameter("date_debut") ;
		
		Date date = new Date();
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		mission.setDate_debut(date);
		
		mission.setDure(Integer.parseInt(request.getParameter("dure")));
		
		mission.setLieu(request.getParameter("lieu"));
		
		noms.update_mission(mission) ;
		
        request.setAttribute("matricule", request.getParameter("matricule"));
        
        this.getServletContext().getRequestDispatcher("/Missions").forward(request, response);
}

}