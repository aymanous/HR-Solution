package com.sdzee.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.octest.bdd.Noms;
import com.octest.beans.Pointage;
import com.octest.beans.Salary;





/**
 * Servlet implementation class Prime
 */
@WebServlet("/Prime")
public class Prime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
     
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/Prime_ID.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		Noms noms = new Noms();
		
		String matricule = request.getParameter("matricule") ;
		
		int id = noms.get_last_salary(matricule) ;
		
		Salary salary = noms.recupperer_salaire(id) ;
		
		Date date= new Date();
	 	
		Calendar cal1 = Calendar.getInstance();

		cal1.setTime(date);

        int current_month = cal1.get(Calendar.MONTH);
        
        int current_year = cal1.get(Calendar.YEAR);
        
        Calendar cal2 = Calendar.getInstance();
        
        int sal_month = 0;
        
        if (salary.getDate() != null ){   
        	cal2.setTime(salary.getDate());

            sal_month = cal2.get(Calendar.MONTH);
        }
        int month, year;
        
        if( current_month == 1  ) {
        	month = 12;
        	year = current_year -1 ;
        } 
        else {
        	month = current_month -1 ;
        	year= current_year;
        }
 
		if( sal_month != month ){
		
		   salary = update_salaire(matricule,month,year);
		   
		   salary.setMatricule(matricule);
		   			
	       noms.add_salaire(salary) ;
	    	
		} 
		
		
	   	float[] h_paie = new float[]{ 0,0 };
		
    	h_paie =  noms.reccupperer_h_paie(matricule) ;
    	
    	request.setAttribute("salaire", salary);
    		
    	request.setAttribute("paie_heure", h_paie[0]);
	
    	request.setAttribute("pex_heure", h_paie[1]);
		
	    this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/Prime_Fiche.jsp").forward(request, response);
	}


	private Salary update_salaire(String matricule, int month, int year) {
		
		Noms noms = new Noms() ;
		
		Salary salary = new Salary() ;
		
		Calendar calendar = Calendar.getInstance();
		 
		 calendar.clear();
		 
		 calendar.set(Calendar.DAY_OF_MONTH,1);
		 
		 calendar.set(Calendar.MONTH, month);
		 
		 calendar.set(Calendar.YEAR, year);
		 
		 Date date_debM = calendar.getTime();
		 
		 calendar.set(Calendar.DAY_OF_MONTH, 31);
		 
		 calendar.set(Calendar.MONTH, month);
		 
		 calendar.set(Calendar.YEAR, year);
		 
		 Date date_finM = calendar.getTime();
		
		 salary.setDate(date_finM); 
		
    	List<Pointage> pts = noms.reccupperer_pts(matricule,date_debM,date_finM);
		
		float nb_heures = 0 ;
		
		int hour2,hour1;
		
		Calendar cal = Calendar.getInstance();
		
		calendar.clear();
		
		for(int i=0; i < pts.size() ; i+=2){
			
	      cal.setTime(pts.get(i+1).getDate());  
			
	   	  hour2 = cal.get(Calendar.HOUR_OF_DAY);	
		
		  cal.setTime(pts.get(i).getDate());  
		
		  hour1 = cal.get(Calendar.HOUR_OF_DAY);
		  
		  nb_heures+= hour2 - hour1  ;  
		
		}
		    
		salary.setNb_heures(nb_heures);
		
		salary.setNb_extra(max(nb_heures-140,0));
		
		salary.setPrime(10);
		
		salary.setImpots(5);
				 
		 
		
		 return salary ;
		
	}

	private float max(float f, float i) {
		if( f > i) return f ;
		else return i;
	}   

}
