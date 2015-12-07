/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.service;

import fr.utbm.projet.entity.Location;
import fr.utbm.repository.HbernateDao;
import java.util.List;

/**
 * <b>LocationService est la classe Charger de gerer toute les interraction avec
 * l'entité Location</b>
 * * <b>LocationService gere aussi les interraction avec hibernate et la
 * BDD</b>
 *
 * @see Location
 * @author lacour florian
 */
public class LocationService {

    /**
     * Methode permettant de retrounée la liste de Location presente dans la BDD
     *
     * @return La liste des Location presente dans la BDD
     */
    public List<Location> getlistCourseCity() {
        // conection a la BDD
        List<Location> lLocation = null;
        HbernateDao repository = new HbernateDao();
        //reciperation de la liste de Location
        lLocation = repository.getListLocation();
        return lLocation;
    }
}
