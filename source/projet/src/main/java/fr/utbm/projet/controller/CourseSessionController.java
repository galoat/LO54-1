/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.controller;

import fr.utbm.projet.entity.CourseSession;
import fr.utbm.projet.service.CourseSessionService;

/**
 *
 * @author galoat
 */
public class CourseSessionController {
    public void getListCourSession(){
     CourseSessionService courseService =new CourseSessionService();
     for(CourseSession cs :courseService.getlistCourseSession()){
         System.out.println("- le cours commence le  "+cs.getDebut()+ " termine le "+cs.getFin()+" a lieu a "+cs.getLieu().getCity()+" la matiére est "+cs.getTheme().getCode());
     }
    }
}
