/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.entity;

/**
 *
 * @author galoat
 */
public class Course {
    String code;
    String titre;
    Location lieu;

    public Course(String code, String titre) {
        this.code = code;
        this.titre = titre;
    }

    public Course() {
    }

    public Location getLieu() {
        return lieu;
    }

    public void setLieu(Location lieu) {
        this.lieu = lieu;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    
}
