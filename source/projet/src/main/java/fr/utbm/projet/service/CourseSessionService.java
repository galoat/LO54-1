/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.service;

import fr.utbm.projet.entity.CourseSession;
import fr.utbm.repository.HbernateDao;
import java.text.SimpleDateFormat;
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
         /*
         SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
          for(CourseSession cSession:lCourse){
              cSession.getDebut();
          }*/
        return lCourse;
     }
      public List<CourseSession> getlistCourseSessionByCode(String code){
        List<CourseSession> lCourse=null;
         HbernateDao repository = new HbernateDao();
         lCourse = repository.getListSession();
         for(int i=0;i<lCourse.size();i++){
              if(!lCourse.get(i).getTheme().getCode().equals(code)){
                    lCourse.remove(i);
                        }
         }
        return lCourse;
     }
     
       public CourseSession getlistCourseSessionByID(int  ID){
        CourseSession cours=null;
         HbernateDao repository = new HbernateDao();
         cours = repository.getCourseSessionByID(ID);
         return cours;
     }
}
