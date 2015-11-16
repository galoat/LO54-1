/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.projet.entity.Client;
import fr.utbm.projet.entity.Course;
import fr.utbm.projet.entity.CourseSession;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author galoat
 */
public class HbernateDao {
    public void save(Client c) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	          session.merge(c);
                 System.out.println("sauvergarde effectuer");
	        session.getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
		}
		finally {
	        if(session != null) {
	            try { session.close();}
                    catch(HibernateException he2) {he2.printStackTrace(); }
                }
                    
                }}
    /*
        TO DO SET MAX RESULT
    */
    public List<Course> getListCourse(){
        List<Course> lCourse=null;
         Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	          Query query = session.createQuery("from Course");
                  lCourse = query.list();   
	        session.getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
		}
		finally {
	        if(session != null) {
	            try { session.close();}
                    catch(HibernateException he2) {he2.printStackTrace(); }
                }
                    
                }
            return lCourse;
    }
     public List<CourseSession> getListSession(){
        List<CourseSession> lCourseSession=null;
         Session session = HibernateUtil.getSessionFactory().openSession();
	    try {
	        session.beginTransaction();
	          Query query = session.createQuery("from CourseSession");
                  lCourseSession = query.list();  
                  for(CourseSession cs : lCourseSession){
                      Hibernate.initialize(cs.getLieu());
                      Hibernate.initialize(cs.getTheme());
                  }
                  
	        session.getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) { 
	            try {
	                session.getTransaction().rollback();	
	            }catch(HibernateException he2) {he2.printStackTrace(); }
	        }
		}
		finally {
	        if(session != null) {
	            try { session.close();}
                    catch(HibernateException he2) {he2.printStackTrace(); }
                }
                    
                }
            return lCourseSession;
    }
}
