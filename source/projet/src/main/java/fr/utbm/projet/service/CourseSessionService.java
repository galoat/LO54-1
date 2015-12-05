/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.service;

import fr.utbm.projet.entity.CourseSession;
import fr.utbm.projet.entity.Location;
import fr.utbm.repository.HbernateDao;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
   
      public List<CourseSession> getlistCourseSessionByCode(String code){
        List<CourseSession>lCourse=null;
         HbernateDao repository = new HbernateDao();
         lCourse =  repository.getListSession();
          
         for(int i=0;i<lCourse.size();i++){
        
             String codeInsideList=lCourse.get(i).getTheme().getCode();
                 if(!(code.compareToIgnoreCase(codeInsideList)==0))
                      {
                          lCourse.remove(i);
                          i--;
                        }
         }
        
        return lCourse;
     }
       public List<CourseSession> getlistCourseSessionByCode(String code, List<CourseSession>lCourseaCopier){
           List<CourseSession> lCourse = new LinkedList(lCourseaCopier);
         for(int i=0;i<lCourse.size();i++){
        
             String codeInsideList=lCourse.get(i).getTheme().getCode();
                 if(!(code.compareToIgnoreCase(codeInsideList)==0))
                      {
                          lCourse.remove(i);
                          i--;
                        }
         }
        
        return lCourse;
     }
      
      
      
          public List<CourseSession> getlistCourseSessionByCity(String city,  List<CourseSession>lCourseaCopier){     
          List<CourseSession> lCourse = new LinkedList(lCourseaCopier);
         for(int i=0;i<lCourse.size();i++){
        
             String stringInsideList=lCourse.get(i).getLieu().getCity();
                 if(!(city.compareToIgnoreCase(stringInsideList)==0))
                      {                
                          lCourse.remove(i);
                          i--;
                        }
         }
        
        return lCourse;
     } 
       public List<CourseSession> getlistCourseSessionByCity(String city){
            List<CourseSession>lCourse=null;
         HbernateDao repository = new HbernateDao(); 
          lCourse =  repository.getListSession();
         for(int i=0;i<lCourse.size();i++){
        
             String stringInsideList=lCourse.get(i).getLieu().getCity();
                 if(!(city.compareToIgnoreCase(stringInsideList)==0))
                      {                
                          lCourse.remove(i);
                          i--;
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
       public List<CourseSession> getlistCourseSessionByDateDebut(Date dateRecherChercher, List<CourseSession>lCourseaCopier){
            List<CourseSession> lCourse = new LinkedList(lCourseaCopier);
         for(int i=0;i<lCourse.size();i++){
        
             Date dateInside=lCourse.get(i).getDebut();
             System.out.println(dateInside.compareTo(dateRecherChercher));
             System.out.println(dateInside);
             System.out.println(dateInside.compareTo(dateRecherChercher));
                 if(dateInside.compareTo(dateRecherChercher)<0)
                      { // si les 2 dates sont differente
                          lCourse.remove(i);
                          i--;
                        }
         }
        
        return lCourse;
     }
       
        public List<Location> getListCity(List<CourseSession>lCourseaCopier){
              List<CourseSession> lCourse = new LinkedList(lCourseaCopier);
            List<Location> location = new LinkedList<Location>();
            for(CourseSession cs : lCourse){
                if(!location.contains(cs.getLieu())){
                      location.add(cs.getLieu());
                }
              
            }
            
            return location;
        }
}
