/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.service;

import fr.utbm.projet.entity.Client;
import fr.utbm.repository.HbernateDao;
import java.util.List;

/**
 *
 * @author galoat
 */
public class ClientService {
    
    public void registerMovie(Client client){
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
