/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.service;

import fr.utbm.projet.entity.Client;
import fr.utbm.projet.entity.CourseSession;
import fr.utbm.repository.HbernateDao;
import java.util.List;

/**
 *
 * @author Lacour Florian
 */
public class ClientService {
    
    
    public Client creerClient(String lastname,String firstname,String addresse, String phone,String email,CourseSession CoursInscrit)
    {
        return new Client(lastname,firstname,addresse,phone,email,CoursInscrit);
    }
    public void registerClient(Client client){
        HbernateDao d = new HbernateDao();
        d.save(client);
    }
    public Client getMovie(){
        Client client =null;
        return client;
    }
    public List<Client> listClient(){
        List<Client> lClient=null;
        return lClient;
    }
     
}
