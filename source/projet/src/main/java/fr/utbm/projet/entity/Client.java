/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.entity;

/**
 * <b>Client est la classe représentant une personne a inscrite a une seul
 * Uv.</b>
 * <p>
 * Un Client est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un identifiant unique attribué définitivement .</li>
 * <li>Un nom nique attribué définitivement.</li>
 * <li> Un prenom attribuer definitivement
 * <li> Une addresse qui peut etre modifié
 * <li> un numero de telpehone qui peut etre changé
 * <li> un email qui peut etre changé
 * </ul>
 * </p>
 * <p>
 * De plus un Client peut etre inscrit a une session de une seul UV
 * (courseSession)
 * </p>
 *
 * @see CourseSession
 * @see Client.hbm.xml
 * @author lacour florian
 */
public class Client {

    /**
     * L'ID du Client. Cet ID n'est pas modifiable. Il sert d'itentifiant pour
     * la base de donnée
     *
     * @see Client.hbm.xml
     */
    private int id;
    /**
     * Le nom de famille du client. Il est stocker dans la BDD
     *
     * @see Client.hbm.xml
     */
    private String lastname;
    /**
     * Le prenom du client. Il est stocker dans la BDD
     *
     * @see Client.hbm.xml
     */
    private String firstname;
    /**
     * L'Adresse du client. Il est stocker dans la BDD
     *
     * @see Client.hbm.xml
     */
    private String addresse;
    /**
     * Le telephone du client. Il est stocker dans la BDD
     *
     * @see Client.hbm.xml
     */
    private String phone;
    /**
     * L'email du client. Il est stocker dans la BDD
     *
     * @see Client.hbm.xml
     */
    private String email;
    /**
     * Le Cours dans lesquel le Client est inscrit
     * <p>
     * Pour de plus amples informations sur les "levels" possibles, regardez la
     * documentation de la classe CourseSession.
     * <p>
     *
     * @see CourseSession
     *
     */
    private CourseSession CoursInscrit;

    /**
     * Constructeur Client.
     * <p>
     * A la construction nous renseignons tous les paramétre du client
     * </p>
     *
     * @param lastname le nom de famille du client
     * @param firstname Le prenom du client
     * @param addresse L'adresse du client
     * @param phone Le numero de telephone du Client
     * @param email L'email du client
     * @param CoursInscrit Le cours dans lesquel notre client c'est inscrit
     * @see Client#CoursInscrit
     * @see Client#lastname
     *  * @see Client#firstname
     *  * @see Client#addresse
     *  * @see Client#phone
     *  * @see Client#email
     */
    public Client(String lastname, String firstname, String addresse, String phone, String email, CourseSession CoursInscrit) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.addresse = addresse;
        this.phone = phone;
        this.email = email;
        this.CoursInscrit = CoursInscrit;
    }

    /**
     * Constructeur Client.
     * <p>
     * A la construction nous renseignons tous les paramétre du client
     * </p>
     *
     * @param lastname le nom de famille du client
     * @param firstname Le prenom du client
     * @param addresse L'adresse du client
     * @param phone Le numero de telephone du Client
     * @param email L'email du client
     * @see Client#lastname
     *  * @see Client#firstname
     *  * @see Client#addresse
     *  * @see Client#phone
     *  * @see Client#email
     */
    public Client(String lastname, String firstname, String addresse, String phone, String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.addresse = addresse;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Constructeur par default de CLient
     */
    public Client() {
    }

    /**
     * methode permettant de retourné les valeurs contenus dans la class client
     * sous forme de String
     *
     * @return Affichage de toute les valeurs contenus dans la class
     */
    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", addresse=" + addresse + ", phone=" + phone + ", email=" + email + ", CoursInscrit=" + CoursInscrit + '}';
    }

    /**
     * Retourne l'ID du CLient.
     *
     * @return ID du client.
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retourne lastname du Client.
     *
     * @return lastname Client.
     */
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CourseSession getCoursInscrit() {
        return CoursInscrit;
    }

    public void setCoursInscrit(CourseSession CoursInscrit) {
        this.CoursInscrit = CoursInscrit;
    }

}
