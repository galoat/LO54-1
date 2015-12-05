/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.service;

import fr.utbm.projet.entity.Location;
import fr.utbm.repository.HbernateDao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author galoat
 */
public class LocationService {
        public List<Location> getlistCourseCity(){
        List<Location> lLocation=null;
         HbernateDao repository = new HbernateDao();
        lLocation=repository.getListLocation();
          ArrayList<String> cityPresente = new ArrayList<>();
          String aVerifier = null;
       for(int i=0;i<lLocation.size();i++){
          aVerifier= lLocation.get(i).getCity();
        
               if(!cityPresente.contains(aVerifier)){
                  cityPresente.add(aVerifier);
               }else
               {
                   lLocation.remove(i);
               }
                   
             
           }
       
        return lLocation;
     }
      public List<Location> getlistCourseCity(  List<Location> lLocation){
           ArrayList<String> cityPresente = new ArrayList<>();
          String aVerifier = null;
       for(int i=0;i<lLocation.size();i++){
          aVerifier= lLocation.get(i).getCity();
        
               if(!cityPresente.contains(aVerifier)){
                  cityPresente.add(aVerifier);
               }else
               {
                   lLocation.remove(i);
               }
                   
             
           }
       
        return lLocation;
     }
    public Location getCityString(String st){
         List<Location> loc=null;
         HbernateDao repository = new HbernateDao();
        loc = repository.getLocationByString(st);
        if(loc.size()==0){
            return null;
        }
        else{
            return loc.get(0);
        }
       
}
    public void save(Location s){
          HbernateDao d = new HbernateDao();
        d.save(s);
    }
}