/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.service;

import fr.utbm.projet.entity.Client;
import fr.utbm.projet.entity.CourseSession;
import fr.utbm.repository.HbernateDao;

/**
 * <b>ClientService est la classe Charger de gerer toute les interraction avec
 * l'entité Client</b>
 * * <b>ClientService gere aussi les interraction avec hibernate et la BDD</b>
 *
 * @see Client
 * @author lacour florian
 */
public class ClientService {

    /**
     * class charger de creer un Client
     *
     * @param lastname Le nom de famille du Client
     * @param firstname Le prenom du CLient
     * @param addresse L'addresse du CLient
     * @param phone Le telephone du CLient
     * @param email L'email de notre Client
     * @param CoursInscrit Le cours dans lesquel notre client est inscrit
     *
     * @return Le client creer
     */

    public Client creerClient(String lastname, String firstname, String addresse, String phone, String email, CourseSession CoursInscrit) {
        return new Client(lastname, firstname, addresse, phone, email, CoursInscrit);
    }

    /**
     * Methode permetant d'enregister un Client dans la base de données
     *
     * @param client Le client a sauvegarder
     * @see HibernateDAO
     */

    public void registerClient(Client client) {
        HbernateDao d = new HbernateDao();
        d.save(client);
    }
}
