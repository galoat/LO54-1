/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.core;

import fr.utbm.repository.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author galoat
 */
public class MainProjet {
    public static void main (String[] args){
 
  Session session=HibernateUtil.getSessionFactory().openSession();

   }
}
