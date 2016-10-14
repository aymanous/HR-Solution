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
import com.octest.beans.Offre;

/**
 * Servlet implementation class Modifier_offre
 */
@WebServlet("/Modifier_offre")
public class Modifier_offre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_offre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		 this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/modifier_offre.jsp").forward(request, response);    
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Noms noms = new Noms();
		
	    Offre offre = new Offre() ;
	    
		offre.setId(Integer.parseInt(request.getParameter("id"))) ;
		
		offre.setPosition(request.getParameter("position"));
		
		offre.setCompetences(request.getParameter("competences"));
		
		offre.setDescription(request.getParameter("description"));
		
		offre.setExperience(Integer.parseInt(request.getParameter("experience")));
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		format.setLenient(false);
		
		String d = request.getParameter("date_pub") ;
		
		Date date = new Date();
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        offre.setDate_pub(date);
        
        d = request.getParameter("date_limite") ;
        
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		offre.setDate_limite(date);
		
		noms.update_offre(offre);
		
        this.getServletContext().getRequestDispatcher("/Offres_emplois").forward(request, response);
	}

}
