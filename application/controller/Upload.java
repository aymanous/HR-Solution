package com.sdzee.servlets;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;

import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;

import com.octest.bdd.Noms;
import com.octest.beans.Offre;




/**

 * Servlet implementation class Test

 */

@WebServlet("/Upload")

public class Upload extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public static final int TAILLE_TAMPON = 10240;

    public static final String CHEMIN_FICHIERS = "C:/fichiers/"; // A changer

    

       

    public Upload() {

        super();

        // TODO Auto-generated constructor stub

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
         Noms noms = new Noms();
		 
		 List<Offre> offres = noms.recuperer_offres();
		 
		 request.setAttribute("offres", offres);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/Candidat/afficher_offres.jsp").forward(request, response);
        
    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    	
    	int id_offre = Integer.parseInt(request.getParameter("id"));
        
    	String position = request.getParameter("position") ;
    	
        // On récupère le champ du fichier

        Part part = request.getPart("fichier");

            

        // On vérifie qu'on a bien reçu un fichier

        String nomFichier = getNomFichier(part);


        // Si on a bien un fichier

        if (nomFichier != null && !nomFichier.isEmpty()) {

            String nomChamp = part.getName();

            // Corrige un bug du fonctionnement d'Internet Explorer

             nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)

                    .substring(nomFichier.lastIndexOf('\\') + 1);


            // On écrit définitivement le fichier sur le disque

            ecrireFichier(part, nomFichier, CHEMIN_FICHIERS);

            Noms noms = new Noms() ;
            
            noms.add_candidature(id_offre,nomFichier,position) ;
            
            request.setAttribute(nomChamp, nomFichier);

        }


        doGet(request,response);

    }


    private void ecrireFichier( Part part, String nomFichier, String chemin ) throws IOException {

        BufferedInputStream entree = null;

        BufferedOutputStream sortie = null;

        try {

            entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);

            sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);


            byte[] tampon = new byte[TAILLE_TAMPON];

            int longueur;

            while ((longueur = entree.read(tampon)) > 0) {

                sortie.write(tampon, 0, longueur);

            }

        } finally {

            try {

                sortie.close();

            } catch (IOException ignore) {

            }

            try {

                entree.close();

            } catch (IOException ignore) {

            }

        }

    }

    

    private static String getNomFichier( Part part ) {

        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {

            if ( contentDisposition.trim().startsWith( "filename" ) ) {

                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );

            }

        }

        return null;

    }   

}