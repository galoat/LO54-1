/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.backoffice;

import fr.utbm.projet.entity.CourseSession;
import fr.utbm.projet.entity.Location;
import fr.utbm.projet.service.CourseSessionService;
import fr.utbm.projet.service.LocationService;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
public class ProjetServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     //CourseSessionService
     /*
      HttpSession session = request.getSession();
               session.setAttribute("list",list );
               
     */         
     
                 HttpSession session = request.getSession();
               
                                
                // recuperation de la des courseSession
               CourseSessionService service = new CourseSessionService();
               List<CourseSession> list = service.getlistCourseSession();    
               request.setAttribute("listCours",list);
              
               session.setAttribute("list", list);
               // Mise e place de la liste des villes 
                 List<Location>listLocation =service.getListCity(list);
                request.setAttribute("listeVille",listLocation);
                RequestDispatcher disp = request.getRequestDispatcher("brackOffice.jsp");
               disp.forward(request, response);
    }

 
 
  
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
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
                 List<CourseSession> list =(List<CourseSession>)session.getAttribute("list");
                 
                 
                 
                  // Si l'utilisateur a renseigner le champ RechercheCode UV on vas rechercher les UV qui contienne ce code
                if(!"".equals(request.getParameter("keyword"))){
                    System.out.println("keyword ");
                      list= service.getlistCourseSessionByCode(request.getParameter("keyword"),list);
                }
                
                
                
              // Si l'utilisateur a renseigner le champ Location UV on vas rechercher les UV qui contienne cetteVille
                if(request.getParameter("location")!=null && !"Toute les Villes".equals(request.getParameter("location"))){
                    System.out.println("location");
                    list = service.getlistCourseSessionByCity(request.getParameter("location"),list);
                }
                
                
                
                
                //  si l'utilisateur a renseigner la date
                if(!"".equals(request.getParameter("dateDebut"))){
                    Date aComparer=null;
                    try {
                        System.out.println(request.getParameter("dateDebut"));
                        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yy");
                        aComparer  = ft.parse(request.getParameter("dateDebut"));
                           System.out.println(aComparer);
                        } catch (ParseException ex) {
                        Logger.getLogger(ProjetServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    list=service.getlistCourseSessionByDateDebut(aComparer, list);
                     
                }
               // on remet la listes des villes
               List<Location>listLocation =service.getListCity(list);
                request.setAttribute("listeVille",listLocation);
               request.setAttribute("listCours",list);
               RequestDispatcher disp = request.getRequestDispatcher("brackOffice.jsp");
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
