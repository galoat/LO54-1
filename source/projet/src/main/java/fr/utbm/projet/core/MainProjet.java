/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.core;

import fr.utbm.projet.controller.CourseController;
import fr.utbm.projet.controller.CourseSessionController;
import fr.utbm.projet.entity.Client;
import fr.utbm.projet.entity.Course;
import fr.utbm.projet.entity.CourseSession;
import fr.utbm.projet.entity.Location;
import fr.utbm.projet.service.ClientService;
import fr.utbm.repository.HbernateDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author galoat
 */
public class MainProjet {
    public static void main (String[] args) throws ParseException{
        Course c = new Course("EC05","Sociologie");
   Location lieu =new Location("Sevenans"); 
   
        SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
        Date debut = ft.parse("24/01/2015");
       Date fin = ft.parse("31/01/2015");
   CourseSession coursSession= new CourseSession(debut,c,lieu, fin);
        
        ClientService clientService = new ClientService();
      Client monClient=  clientService.creerClient("Client","client","Addresse client", "06122291","client@email",coursSession);
      clientService.registerClient(monClient);
    }
}
