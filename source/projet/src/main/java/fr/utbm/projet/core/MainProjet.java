/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.core;

import fr.utbm.projet.entity.Client;
import fr.utbm.projet.entity.Course;
import fr.utbm.projet.entity.CourseSession;
import fr.utbm.repository.HbernateDao;
import java.util.Date;

/**
 *
 * @author galoat
 */
public class MainProjet {
    public static void main (String[] args){
 
  HbernateDao sv = new HbernateDao();
  //Session session = HibernateUtil.getSessionFactory().openSession();
   Date d = new Date(2015, 01, 01);
   Course c = new Course("LO43","JAVA");
   CourseSession coursSession= new CourseSession(d,c);
   Client client= new  Client("Lacour", "Florian", "ma super addresse", "mon telephone", "mon email",coursSession) ;
   sv.save(client);
   
    }
}
