/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.backoffice;


import fr.utbm.projet.entity.Client;
import fr.utbm.projet.entity.CourseSession;
import fr.utbm.projet.service.ClientService;
import fr.utbm.projet.service.CourseSessionService;
import java.io.IOException;
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
public class ServletInscription extends HttpServlet {

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
          
          int ID=Integer.parseInt(request.getParameter("InscriptionCours"));
           HttpSession session = request.getSession();
           session.setAttribute("InscriptionCours", ID);
          
        CourseSessionService cs = new CourseSessionService();
        CourseSession cours=cs.getlistCourseSessionByID(ID);
        request.setAttribute("InscriptionCours",cours);   
        
         RequestDispatcher disp = request.getRequestDispatcher("JSPInscription.jsp");
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
    @Override
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
        int ID =(Integer) session.getAttribute("InscriptionCours");
        CourseSessionService cs = new CourseSessionService();
        CourseSession cours=cs.getlistCourseSessionByID(ID);
        ClientService ClientService = new ClientService();
        Client Client= ClientService.creerClient(request.getParameter("LName"), request.getParameter("FName"), request.getParameter("Adresse"), request.getParameter("Phone"), request.getParameter("Email"), cours);
        ClientService.registerClient(Client);
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
