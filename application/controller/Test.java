package com.sdzee.servlets;


import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.bdd.Noms;




/**

 * Servlet implementation class Test

 */

@WebServlet("/Test")

public class Test extends HttpServlet {

    private static final long serialVersionUID = 1L;

    

       

    public Test() {

        super();

        // TODO Auto-generated constructor stub

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        

        this.getServletContext().getRequestDispatcher("/WEB-INF/Authentification/acceuil.jsp").forward(request, response);

    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {


        String login = request.getParameter("login");

        String password = request.getParameter("password");
            
         Noms noms = new Noms() ;
         
         String matricule = noms.getMatricule(login,password) ;
         
         String position= null ;
         
         position = noms.getPosition(matricule) ;
         
         HttpSession session = request.getSession();

         session.setAttribute("matricule", matricule);
         
         session.setAttribute("position", position);
         
                 
       if(position != null)
       {
    	   if(position.equals("HR Director")){
           this.getServletContext().getRequestDispatcher("/WEB-INF/Authentification/Admin.jsp").forward(request, response);
      }
        else if (position.equals("Chef Executif"))
           this.getServletContext().getRequestDispatcher("/WEB-INF/Authentification/Chef_Service.jsp").forward(request, response);
        else 
        	this.getServletContext().getRequestDispatcher("/WEB-INF/Authentification/Employe.jsp").forward(request, response);
        
    }
       else 
       	this.getServletContext().getRequestDispatcher("/WEB-INF/Authentification/acceuil.jsp").forward(request, response);
    }

   
}