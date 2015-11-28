/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.entity;

/**
 * UN client a un seul course session => une personne peut etrez considérer comme plusieurs clients.
 * @author galoat
 */
public class Client {
    private int id;
    private String lastname;
    private String firstname;
    private String addresse;
    private String phone;
    private String email;
    private CourseSession CoursInscrit;

    public Client(String lastname, String firstname, String addresse, String phone, String email, CourseSession CoursInscrit) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.addresse = addresse;
        this.phone = phone;
        this.email = email;
        this.CoursInscrit = CoursInscrit;
    }

    public Client(String lastname, String firstname, String addresse, String phone, String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.addresse = addresse;
        this.phone = phone;
        this.email = email;
    }

    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", addresse=" + addresse + ", phone=" + phone + ", email=" + email + ", CoursInscrit=" + CoursInscrit + '}';
    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
