/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.controller;

import fr.utbm.projet.entity.Course;
import fr.utbm.projet.service.CourseService;

/**
 *
 * @author galoat
 */
public class CourseController {
    public void getListCours(){
        CourseService cService= new CourseService();
        for(Course c :cService.listClient()){
            System.out.println(" - "+c.getCode()+ " theme : "+c.getTitre());
        }
        
    }
}
