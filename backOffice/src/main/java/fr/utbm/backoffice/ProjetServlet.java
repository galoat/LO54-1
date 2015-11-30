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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
                // Recuperation des Villes
                LocationService lservice= new LocationService();
                List<Location>listLocation=  lservice.getlistCourseCity();
                request.setAttribute("listeVille",listLocation);
                                
                // recuperation de la des courseSession
               CourseSessionService service = new CourseSessionService();
               List<CourseSession> list = service.getlistCourseSession();
               request.setAttribute("listCours",list);
                RequestDispatcher disp = request.getRequestDispatcher("brackOffice.jsp");
               disp.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
               List<CourseSession> list = service.getlistCourseSessionByCode(request.getParameter("keyword"));
               HttpSession session = request.getSession();
               session.setAttribute("listCours", list);
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
    protected Date stringToDate(String dates){
        Date date=null;
        if(dates != null){
            SimpleDateFormat formatage= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date1 =dates;
            try {
                date = formatage.parse(date1);
                
            } catch (Exception e) {
            }
        }
        return date;
    }
}
