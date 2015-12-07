/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.backoffice;

import fr.utbm.projet.entity.CourseSession;
import fr.utbm.projet.entity.Location;
import fr.utbm.projet.service.CourseSessionService;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author galoat
 */
public class ServletBackOffice extends HttpServlet {

    

 
 
  
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           HttpSession session = request.getSession();
                                           
               // recuperation de des courseSession
               CourseSessionService service = new CourseSessionService();
               List<CourseSession> list = service.getlistCourseSession();    
               request.setAttribute("listCours",list);
              // Sauvegarde de cette liste dans la session
               // on considére que cette liste ne changeras pas pendant tous le temps de nos transaction
               session.setAttribute("list", list);
               // Mise ne place de la liste des villes 
                 List<Location>listLocation =service.getListCity(list);
                request.setAttribute("listeVille",listLocation);
                //On envoit envoit tuso cela a la JSP backOffice
                RequestDispatcher disp = request.getRequestDispatcher("backOffice.jsp");
               disp.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Gestion de la fonction recherche
                
                CourseSessionService service = new CourseSessionService();
                HttpSession session = request.getSession();
                // On recupére la liste des courseSession qui on été stocké dans la Session 
                List<CourseSession> list =(List<CourseSession>)session.getAttribute("list");
                 
                 
                 
                  // Si l'utilisateur a renseigner le champ RechercheCode UV on vas rechercher les UV qui contienne ce code
                if(!"".equals(request.getParameter("keyword"))){
                      list= service.getlistCourseSessionByCode(request.getParameter("keyword"),list);
                }
                
                               
              // Si l'utilisateur a renseigner le champ Location UV on vas rechercher les UV qui contienne cetteVille
                if(!"Toute les Villes".equals(request.getParameter("location"))){
                    System.out.println("location");
                    list = service.getlistCourseSessionByCity(request.getParameter("location"),list);
                }
                            
                //  si l'utilisateur a renseigner la date on effectu un trie sur la Date
                if(!"".equals(request.getParameter("dateDebut"))){
                    Date aComparer=null;
                    try {
                        // le format rentrer par l'utilisateur doit étre dd/MM:yy
                        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yy");
                        aComparer  = ft.parse(request.getParameter("dateDebut"));
                         
                        } catch (ParseException ex) {
                        Logger.getLogger(ServletBackOffice.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    list=service.getlistCourseSessionByDateDebut(aComparer, list);
                     
                }
               // on remet la listes des villes qui sont presente dans notre nouvelle liste
               List<Location>listLocation =service.getListCity(list);
                request.setAttribute("listeVille",listLocation);
               request.setAttribute("listCours",list);
               RequestDispatcher disp = request.getRequestDispatcher("backOffice.jsp");
               disp.forward(request, response);
           
    }

     
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
   
}
