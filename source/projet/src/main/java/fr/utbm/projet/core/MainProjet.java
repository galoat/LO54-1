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
import fr.utbm.repository.HbernateDao;
import java.util.Date;

/**
 *
 * @author galoat
 */
public class MainProjet {
    public static void main (String[] args){
 /*
  HbernateDao sv = new HbernateDao();
  //Session session = HibernateUtil.getSessionFactory().openSession();
   Date debut = new Date(2015, 01, 01);
   Date fin = new Date(2015, 02, 02);
   Course c = new Course("LO43","JAVA");
   Location lieu =new Location("UTBM-BELFORT");
   CourseSession coursSession= new CourseSession(debut,c,lieu,fin);
   Client client= new  Client("Bidule2", "machin2", "addresse machin2 ", "mon telephone machin2", "mon email machin2",coursSession) ;
   sv.save(client);
   */
       CourseSessionController cs = new CourseSessionController();
       cs.getListCourSession();
   /*
      ClientController c = new ClientController();
        c.createClientFromConsole();
   */
    }
}
