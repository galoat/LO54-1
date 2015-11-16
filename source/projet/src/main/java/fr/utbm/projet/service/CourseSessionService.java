/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.service;

import fr.utbm.projet.entity.Course;
import fr.utbm.projet.entity.CourseSession;
import fr.utbm.repository.HbernateDao;
import java.util.List;

/**
 *
 * @author galoat
 */
public class CourseSessionService {
    public List<CourseSession> getlistCourseSession(){
        List<CourseSession> lCourse=null;
         HbernateDao repository = new HbernateDao();
         lCourse = repository.getListSession();
        return lCourse;
     }
}
