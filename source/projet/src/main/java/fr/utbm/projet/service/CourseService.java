/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.projet.service;

import fr.utbm.projet.entity.Course;
import fr.utbm.repository.HbernateDao;
import java.util.List;

/**
 * <b>CourseService est la classe Charger de gerer toute les interraction avec
 * l'entité Course</b>
 * * <b>CourseService gere aussi les interraction avec hibernate et la BDD</b>
 *
 * @see Course
 * @author lacour florian
 */
public class CourseService {

    /**
     * Classe permettant de connaitre la liste de Course présent dans la BDD
     *
     * @return la liste des Cours present en BDD
     */
    public List<Course> listClient() {
        List<Course> lCourse = null;
        HbernateDao repository = new HbernateDao();
        lCourse = repository.getListCourse();
        return lCourse;
    }

}
