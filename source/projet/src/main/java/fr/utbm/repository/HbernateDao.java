/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package fr.utbm.repository;

import fr.utbm.projet.entity.Client;
import fr.utbm.projet.entity.Course;
import fr.utbm.projet.entity.CourseSession;
import fr.utbm.projet.entity.Location;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * <b>HibernateDao est une classe qui contient toutes les fonctions qui
 * permettent de communiquer avec la base de données pour stocker des données ou
 * bien retourner des résultats</b>
 * <p>
 * L'ensemble des fonctions est:
 * <ul>
 * <li>Enregister un client</li>
 * <li>Retourner la liste des courses</li>
 * <li>Retourner la session d'un cours par un identifiant
 * <li>Retourner la liste des sessions
 * <li>Retourner la liste des emplacements
 * <li>Retourner la liste des emplacements dans une ville
 * <li>Enregister un emplacement
 * </ul>
 * </p>
 */


public class HbernateDao {

    /**
     * methode permettant d'enregister un nouveau client dans la base de données
     *
     * @return le client est stocké dans la base de données et le message
     * "sauvgarde effectué" est affiché sur la console
     * @param c l'objet client qu'on veut enregister
     */
    public void save(Client c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(c);
            System.out.println("sauvergarde effectuer");
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }

        }
    }

    /**
     * methode permettant de retourner la session des cours par l'identifiant,
     * qui est unique, en effectuant une recherche dans la base de données, sur
     * l'identifiant de la session
     *
     * @return la session dont son identifiant= ID
     * @param ID l'identifiant de la sassion qu'on veut chercher
     */
    public CourseSession getCourseSessionByID(int ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseSession retour = null;
        try {
            session.beginTransaction();
            retour = (CourseSession) session.get(CourseSession.class, ID);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }

        }
        return retour;
    }
    /*
     TO DO SET MAX RESULT
     */

    /**
     * methode permettant de retourner la liste des courses disponible dans la
     * base de données
     *
     * @return la liste des cours
     */
    public List<Course> getListCourse() {
        List<Course> lCourse = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Course");
            lCourse = query.list();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }

        }
        return lCourse;
    }

    /**
     * methode permettant de retourner la liste des sessions disponible dans la
     * base de données
     *
     * @return la liste des sessions
     */
    public List<CourseSession> getListSession() {
        List<CourseSession> lCourseSession = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from CourseSession");
            lCourseSession = query.list();
            for (CourseSession cs : lCourseSession) {
                Hibernate.initialize(cs.getLieu());
                Hibernate.initialize(cs.getTheme());
            }

            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }

        }
        return lCourseSession;
    }

    /**
     * methode permettant de retourner la liste des emplacement disponible dans
     * la base de données
     *
     * @return la liste des emplacements
     */
    public List<Location> getListLocation() {
        List<Location> lCourLocation = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Location ");
            lCourLocation = query.list();

            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }

        }
        return lCourLocation;
    }

    /**
     * methode permettant de retourner la liste des emplacement disponible dans
     * la base de données, pour une ville données
     *
     * @return la liste des emplacement dont la ville = ville
     * @param ville le nom de la ville qu'on veut chercher sa liste
     * d'emplacement
     */
    public List<Location> getLocationByString(String ville) {
        List<Location> lCourLocation = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from Location u where city = ? ");
            query.setParameter(0, ville);
            lCourLocation = query.list();

            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }

        }
        return lCourLocation;
    }

    /**
     * methode permettant de stocker dans la base de données un nouvel
     * emplacement
     *
     * @return l'emplacement est bien enregistré dans la base de données
     */
    public void save(Location c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(c);

            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }

        }
    }
}
