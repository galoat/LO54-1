/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.entity;

import java.util.Date;
/**
 * <b>CourseSession est la classe représentant une session  d'un cours</b>
 * <p>
 * Un CourseSession est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un identifiant unique attribué définitivement .</li>
 * <li>Une Date de debut.</li>
 * <li> Un date de fin</li>
 * <li> un sujet sur lesquel le cours se deroullera (theme)</li>
 * <li> Une location representant l'endroit ou se deroule notre cours</li>
 * </ul>
 * </p>
 * <p>
 * Une courseSession ne peut avoir qu'un seul theme et plusieurs CourseSession peuvent se derouler a plusieurs endroit en meme
 * temps.
 * </p>
 * 
 * 
 * @see CourseSession.hbm.xml
 * @author lacour florian
 */
public class CourseSession {
     /**
         * L'ID de CourSession. Cet ID n'est pas modifiable.
         * Il sert d'itentifiant pour la base de donnée
         * @see CourseSession.hbm.xml
         */
    private int ID;
    /**
      * La date de debut CourSession.
      * Represente la Date de debut de cours
         * @see CourseSession.hbm.xml
         */
    private Date debut;
    /**
      * La date de fin CourSession.
      * Represente la Date de fin de cours
         * @see CourseSession.hbm.xml
         */
    private Date fin;
    /**
      * Le Theme de fin CourSession.
      * Represente le sujet abordé durant le cours
         * @see CourseSession.hbm.xml
         * @see Course
         */
    private Course theme;
    /**
      * La Location de  CourSession.
      * Represente la position ou se deroullera le cours
         * @see CourseSession.hbm.xml
         * @see Location
         */
    private Location lieu;
    
     /**
         * Constructeur CourseSession.
         * <p>
         * A la construction nous renseignons tous les paramétre de CourseSession
         * </p>
         * 
         * @param Debut 
         *           le Debut de notre cours
         *@param theme
         *  Le sujet de notre cours
         * @param location
         *  La localisation de notre cours
         * @param fin
         *      La date de fin de notre COurs
         * 
        
         */
    public CourseSession(Date Debut, Course theme, Location location,Date fin){
        this.debut=Debut;
        this.theme = theme;
        this.lieu= location;
        this.fin=fin;
    }
    /**
     * Constructeur par default de CourseSession
     */
    public CourseSession(){
        
    }
 /**
     * methode permettant de retourné les valeurs contenus dans la class CourseSession sous forme de String
     * @return Affichage de toute les valeurs contenus dans la class
     */
    @Override
    public String toString() {
        return "CourseSession{" + "ID=" + ID + ", debut=" + debut + ", fin=" + fin + ", theme=" + theme + ", lieu=" + lieu + '}';
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
