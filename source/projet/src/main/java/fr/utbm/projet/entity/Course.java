/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.entity;

/**
 * <b>Course est la classe représentant un cours </b>
 * <p>
 * Un Cours est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un code d'UV qui sert aussi d'identifiant.</li>
 * <li> Un titre d'UV qui precise ce que fait un client</li>
 * </ul>
 * </p>
 * <p>
 * </p>
 *
 *
 * @see Course.hbm.xml
 * @author lacour florian
 */
public class Course {

    /**
     * Le Code de l'UV. Ce code n'est pas modifiable. Il sert d'itentifiant pour
     * la base de donnée
     *
     * @see Course.hbm.xml
     */
    String code;
    /**
     * Le Titre de l'UV. Ce code n'est pas modifiable.
     *
     * @see Course.hbm.xml
     */
    String titre;

    /**
     * Constructeur Course.
     * <p>
     * A la construction nous renseignons tous les paramétre du cours
     * </p>
     *
     * @param code : Le code de l'UV
     * @param titre : le titre de l'UV
     */
    public Course(String code, String titre) {
        this.code = code;
        this.titre = titre;
    }

    /**
     * Constructeur par default
     */
    public Course() {
    }

    /**
     * methode permettant de retourné les valeurs contenus dans la class Course
     * sous forme de String
     *
     * @return String : Affichage de toute les valeurs contenus dans la class
     */
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
