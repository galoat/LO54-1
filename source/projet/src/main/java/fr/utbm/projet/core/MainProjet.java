/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.core;

import fr.utbm.projet.entity.Client;
import fr.utbm.projet.entity.CourseSession;
import fr.utbm.repository.HbernateDao;
import fr.utbm.repository.HibernateUtil;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author galoat
 */
public class MainProjet {
    public static void main (String[] args){
 
  HbernateDao sv = new HbernateDao();
  //Session session = HibernateUtil.getSessionFactory().openSession();
   Date d = new Date(2015, 01, 01);
   CourseSession coursSession= new CourseSession(d);
   Client c= new  Client("Lacour", "Florian", "ma super addresse", "mon telephone", "mon email",coursSession) ;{
   sv.save(c);
   
    }
}}
