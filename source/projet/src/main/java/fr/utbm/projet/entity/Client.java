/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.entity;
import java.util.LinkedList;
/**
 *
 * @author galoat
 */
public class Client {
    private int id;
    private String lastname;
    private String firstname;
    private String addresse;
    private int phone;
    private String email;
    private LinkedList<Course> CoursInscrit;

    public Client() {}
    public Client(int id, String lastname, String firstname, String addresse, int phone, String email) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.addresse = addresse;
        this.phone = phone;
        this.email = email;
     
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LinkedList<Course> getCoursInscrit() {
        return CoursInscrit;
    }

    public void setCoursInscrit(LinkedList<Course> CoursInscrit) {
        this.CoursInscrit = CoursInscrit;
    }

            
}
