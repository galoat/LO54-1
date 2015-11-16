/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.controller;

import fr.utbm.projet.entity.Client;
import fr.utbm.repository.HbernateDao;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author galoat
 */
public class ClientController {
    public void createClientFromConsole(){
       Scanner sc = new Scanner(System.in);
        System.out.println("Quel est le nom du client");
        String nom = sc.nextLine();
        System.out.println("Quel est le prenom  du client");
        String prenom = sc.nextLine();
        System.out.println("Quel est l 'adresse du client ?");
        String adrres =sc.nextLine();
        System.out.println("Quel est le telephone du client ?");
        String phone = sc.nextLine();
        System.out.println("Quel est l'email du client ?");
        String email= sc.nextLine();
        Client client= new  Client("Lacour", "Florian", "ma super addresse", "mon telephone", "mon email") ;
        
        
        
        /*
        System.out.println("Quel est la date de depart :");
        Date debut = getDate(sc);
        System.out.println("Quel est la date de depart :");
        Date fin = getDate(sc);
        
   Course c = new Course("LO43","JAVA");
   Location lieu =new Location("Belfort");
   CourseSession coursSession= new CourseSession(debut,c,lieu,fin);
  
   sv.save(client);*/
       
    }
    private Date getDate(Scanner sc){
        System.out.println("\t l'année ?");
        int année= sc.nextInt();
        System.out.println("\t le mois ?");
        int mois = sc.nextInt();
        System.out.println("\t le jour ?");
        int jour= sc.nextInt();
        return  new Date(année, mois, jour);
    }
    
}
