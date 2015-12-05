/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.core;

import fr.utbm.projet.entity.Client;
import fr.utbm.projet.entity.Course;
import fr.utbm.projet.entity.CourseSession;
import fr.utbm.projet.entity.Location;
import fr.utbm.projet.service.ClientService;
import fr.utbm.projet.service.CourseSessionService;
import fr.utbm.projet.service.LocationService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author galoat
 */
public class MainProjet {
    public static void main (String[] args) throws ParseException{
         
      /*
   
       Location  lieu =new Location("Belfort");
       Course c = new Course("LO43","JAVA SE");
  
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        Date debut = ft.parse("4/01/2015");
       Date fin = ft.parse("10/01/2015");
   CourseSession coursSession= new CourseSession(debut,c,lieu,fin);
        
        ClientService clientService = new ClientService();
      Client monClient=  clientService.creerClient("Client","client","Addresse client", "06122291","client@email",coursSession);
      clientService.registerClient(monClient);*/
          CourseSessionService service = new CourseSessionService();
               List<CourseSession> list = service.getlistCourseSessionByCode("LO43");
               System.out.println(list.toString());
           }
}
