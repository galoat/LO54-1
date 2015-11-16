/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.core;

import fr.utbm.projet.entity.Client;
import fr.utbm.repository.HbernateDao;
import fr.utbm.repository.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author galoat
 */
public class MainProjet {
    public static void main (String[] args){
 
  
  Client c= new Client("lacour","Florian","Addresse","061225491","mone email");
  HbernateDao sv = new HbernateDao();
   Session session = HibernateUtil.getSessionFactory().openSession();
  //sv.save(c);
  /*
  Date d = new Date(2014,10,10);
  CourseSession cs = new CourseSession(d);
  c.getCoursInscrit().add(cs);
  sv.save(c);*/
   }
}
