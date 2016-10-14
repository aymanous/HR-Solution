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
import com.octest.beans.Formation;

/**
 * Servlet implementation class Modifier_formation
 */
@WebServlet("/Modifier_formation")
public class Modifier_formation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_formation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
		 this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/Modifier_formation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Noms noms =new Noms() ;
		
		Formation formation = new Formation() ;
		
		formation.setId(Integer.parseInt(request.getParameter("id")));
		
		formation.setService(request.getParameter("service"));
		
		formation.setTheme(request.getParameter("theme"));
		
		formation.setBudget(Float.parseFloat(request.getParameter("budget")));
		
		formation.setDure_moy(Integer.parseInt(request.getParameter("dure_moy")));
		
		formation.setPriorite(Integer.parseInt(request.getParameter("priorite")));
		
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
				
		formation.setDate_debut(date);
		
        d = request.getParameter("date_fin") ;
		
		try {
			date = format.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		formation.setDate_fin(date);
		
		formation.setLieu(request.getParameter("lieu"));
		
		noms.update_formation(formation) ;
		
		this.getServletContext().getRequestDispatcher("/Liste_formations").forward(request, response);
		
	}

}
