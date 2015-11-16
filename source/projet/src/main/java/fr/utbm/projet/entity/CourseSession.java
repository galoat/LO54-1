/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.entity;

import java.util.Date;

/**
 *
 * @author galoat
 */
public class CourseSession {
    private int ID;
    private Date debut;
    private Date fin;
    private Course theme;
    private Location lieu;
    public CourseSession(Date Debut){
        
    }
    public CourseSession(){
        
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Course getTheme() {
        return theme;
    }

    public void setTheme(Course theme) {
        this.theme = theme;
    }

    public Location getLieu() {
        return lieu;
    }

    public void setLieu(Location lieu) {
        this.lieu = lieu;
    }
    
}
