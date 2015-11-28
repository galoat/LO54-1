/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.service;

import fr.utbm.projet.entity.Course;
import fr.utbm.repository.HbernateDao;
import java.util.List;

/**
 *
 * @author galoat
 */
public class CourseService {
     public List<Course> listClient(){
        List<Course> lCourse=null;
         HbernateDao repository = new HbernateDao();
         lCourse =repository.getListCourse();
        return lCourse;
     }
     
}
