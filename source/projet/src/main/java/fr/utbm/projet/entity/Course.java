/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.entity;

import java.util.List;

/**
 *
 * @author galoat
 */
public class Course {
    String code;
    String titre;
    

    public Course(String code, String titre) {
        this.code = code;
        this.titre = titre;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" + "code=" + code + ", titre=" + titre + '}';
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
