/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.repository;

import fr.utbm.projet.entity.Client;
import org.hibernate.HibernateException;
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
}
