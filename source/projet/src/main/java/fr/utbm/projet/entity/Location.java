/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.entity;

import java.io.Serializable;

/**
 * <b>Location est la classe représentant une position</b>
 * <p>
 * Un Location est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un identifiant unique attribué définitivement .</li>
 * <li> un String representant le nom de notre localisation</li>
 * </ul>
 * </p>
 * <p>

 * </p>
 * 
 * 
 * @see Location.hbm.xml
 * @author lacour florian
 */
public class Location implements Serializable {
      /**
      * L ID de de la Locatio,
      * Il s'agit aussi de L'ID hibernate
         * @see Location.hbm.xml
         */
    private int id;
    /**
      * le nom de la Location,
     
         * @see Location.hbm.xml
         */
    
    private String city;
/**Constructeur permetant de creer un ville avec en paramétre le nom de la ville
    
    */
    public Location(String city) {
        this.city = city;
    }
    /**
    Constructeur par default
    
    */
    public Location() {
    }
/**
     * methode permettant de retourné les valeurs contenus dans la class Location sous forme de String
     * @return Affichage de toute les valeurs contenus dans la class
     */
    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", city=" + city + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}
