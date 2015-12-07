/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.service;

import fr.utbm.projet.entity.CourseSession;
import fr.utbm.projet.entity.Location;
import fr.utbm.repository.HbernateDao;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * <b>CourseSessionService est la classe Charger de gerer toute les interraction
 * avec l'entité CourseSession </b>
 * <b>CourseSessionService gere aussi les interraction avec hibernate et la
 * BDD</b>
 *
 * @see CourseSession
 * @author lacour florian
 */
public class CourseSessionService {

    /**
     * Methode permettant de retourné la liste de tout les cours Session en BDD
     *
     * @return la liste de tous le coursSession Present en BDD
     */
    public List<CourseSession> getlistCourseSession() {
        List<CourseSession> lCourse = null;
        HbernateDao repository = new HbernateDao();
        lCourse = repository.getListSession();
        return lCourse;
    }

    /**
     * Methode permettant de retournée la liste de CourseSession celon le sujet
     * abordé Le sujet abordé est representé sous forme du code de l'UV Cette
     * fonction vas cherché en BDD la liste des CourseSession
     *
     * @param code le code de L'UV
     * @return List< CourseSession >
     * List de coursession qui ont pour sujet code
     * @see getlistCourseSessionByCode(String code,
     * List<CourseSession>lCourseaCopier)
     */
    public List<CourseSession> getlistCourseSessionByCode(String code) {
        List<CourseSession> lCourse = null;
        // On vas cherché la liste de Course session en BDD
        HbernateDao repository = new HbernateDao();
        lCourse = repository.getListSession();
        // On recupére que les cours qui correspond au code de l'UV
        lCourse = getlistCourseSessionByCode(code, lCourse);
        return lCourse;
    }

    /**
     * Methode permettant de retournée la liste de CourseSession celon le sujet
     * abordé Le sujet abordé est representé sous forme du code de l'UV
     *
     * @param code le code de L'UV que l'on cherche
     * @param lCourseaCopier La liste contenant les CourseSession dans lesquel
     * on recherche Code
     * @return List CourseSession
     * List de coursession qui ont pour sujet code
     */
    public List<CourseSession> getlistCourseSessionByCode(String code, List<CourseSession> lCourseaCopier) {
        // on copie l'entré dans une nouvelle liste afin de ne pas supprimé de COurseSession dans la liste en paramétre
        List<CourseSession> lCourse = new LinkedList(lCourseaCopier);
        // Pour tous les cours qui sont la liste 
        for (int i = 0; i < lCourse.size(); i++) {
            //on recupére le code de l'UV du coursSession
            String codeInsideList = lCourse.get(i).getTheme().getCode();
            //si les 2 code sont different alors le sujet n'est pas le méme
            if (!(code.compareToIgnoreCase(codeInsideList) == 0)) {     // on supprime le courseSession de la liste a renvoyer
                lCourse.remove(i);
                          // commme la liste a perdu une entité lCourse.size() vaut 1 de moins qu'auparavant 
                //de ce fait si on veut parcourir la liste il faut recommencer un traitement sur la méme valeur i
                i--;
            }
        }

        return lCourse;
    }

    /**
     * Methode permettant de retournée la liste de CourseSession celon la ville
     * ou se déroule le cours Les Données sont stocker dans la BDD
     *
     * @param city La ville que l'on cherche
     * @param lCourseaCopier La liste contenant les CourseSession dans lesquel
     * on recherche la ville
     * @return List<CourseSession>
     * List de coursession qui ont pour ville city
     */
    public List<CourseSession> getlistCourseSessionByCity(String city, List<CourseSession> lCourseaCopier) {
        // on copie l'entré dans une nouvelle liste afin de ne pas supprimé de COurseSession dans la liste en paramétre                  
        List<CourseSession> lCourse = new LinkedList(lCourseaCopier);
        // Pour tous les cours qui sont la liste 
        for (int i = 0; i < lCourse.size(); i++) {

            String stringInsideList = lCourse.get(i).getLieu().getCity();
            if (!(city.compareToIgnoreCase(stringInsideList) == 0)) {   // on supprime le courseSession de la liste a renvoyer
                lCourse.remove(i);
                          // commme la liste a perdu une entité lCourse.size() vaut 1 de moins qu'auparavant 
                //de ce fait si on veut parcourir la liste il faut recommencer un traitement sur la méme valeur i
                i--;
            }
        }

        return lCourse;
    }

    /**
     * Methode permettant de retournée la liste de CourseSession celon le nom de
     * la ville ou se deroule le cours Cette fonction vas cherché en BDD la
     * liste des CourseSession
     *
     * @param city le nom de la ville
     * @return List< CourseSession >
     * List de coursession qui ont pour ville : city
     * @see getlistCourseSessionByCity(String city,
     * List<CourseSession>lCourseaCopier)
     */
    public List<CourseSession> getlistCourseSessionByCity(String city) {
        // On vas cherché la liste de Course session en BDD
        List<CourseSession> lCourse = null;
        HbernateDao repository = new HbernateDao();
        lCourse = repository.getListSession();
        // On recupére que les cours qui correspond au code de l'UV
        lCourse = getlistCourseSessionByCity(city, lCourse);
        return lCourse;
    }

    /**
     * Methode permetant de recuperer un courseSession en BDD en fonction de
     * l'ID de celui-ci
     *
     * @param ID l'ID du COurseSession
     * @return
     */
    public CourseSession getlistCourseSessionByID(int ID) {
        CourseSession cours = null;
        HbernateDao repository = new HbernateDao();
        cours = repository.getCourseSessionByID(ID);

        return cours;
    }

    /**
     * Methode permettant de connaitre la lsite de CourseSession dont la Date de
     * debut est apres la date envoyé en paramétre
     *
     * @param dateRecherChercher date a partir de lasquel on cherche les
     * courseSession
     * @param lCourseaCopier List Dans lasquel on doit cherché les Date
     * @return
     */
    public List<CourseSession> getlistCourseSessionByDateDebut(Date dateRecherChercher, List<CourseSession> lCourseaCopier) {
        // on copie l'entré dans une nouvelle liste afin de ne pas supprimé de COurseSession dans la liste en paramétre                  
        List<CourseSession> lCourse = new LinkedList(lCourseaCopier);
        //Pour tous les CourseSession dans la lite
        for (int i = 0; i < lCourse.size(); i++) {
            // On recupére la date de dbut presente dans la liste
            Date dateInside = lCourse.get(i).getDebut();
            // Si la Date recherché est avant la Date de présente dans la liste
            if (dateInside.compareTo(dateRecherChercher) < 0) { // on supprime le courseSession de la liste a renvoyer
                lCourse.remove(i);
                          // commme la liste a perdu une entité lCourse.size() vaut 1 de moins qu'auparavant 
                //de ce fait si on veut parcourir la liste il faut recommencer un traitement sur la méme valeur i

                i--;
            }
        }

        return lCourse;
    }

    /**
     * Methode permettant de retourné la liste des location contenus dans la
     * liste de CourseSession
     *
     * @param lCourseaCopier List dans lasquel on doit retourné la liste des
     * location
     * @return une list de location qui contient tout les ville
     */
    public List<Location> getListCity(List<CourseSession> lCourseaCopier) {
        // on copie l'entré dans une nouvelle liste afin de ne pas supprimé de COurseSession dans la liste en paramétre                  
        List<CourseSession> lCourse = new LinkedList(lCourseaCopier);
        //list de location que nous retourneront
        List<Location> location = new LinkedList<>();
        // pour tous les CourseSession dans la liste
        for (CourseSession cs : lCourse) {
            // si la liste de location ne contient pas le CourseSession alors on l'ajoute a la lite de COurseSession
            if (!location.contains(cs.getLieu())) {
                location.add(cs.getLieu());
            }

        }

        return location;
    }
}
