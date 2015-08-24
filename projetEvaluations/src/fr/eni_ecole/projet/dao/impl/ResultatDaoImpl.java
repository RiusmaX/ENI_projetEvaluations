package fr.eni_ecole.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.eni_ecole.entities.Resultat;

/**
 * 
 * @author d1409sergentm
 *
 */
public class ResultatDaoImpl {

	private static final Log log = LogFactory.getLog(ResultatDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public Resultat findById(int id) {
		log.debug("getting Resultat instance with id: " + id);
		try {
			final Resultat instance = this.entityManager.find(Resultat.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (final RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Resultat merge(Resultat detachedInstance) {
		log.debug("merging Resultat instance");
		try {
			final Resultat result = this.entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (final RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void persist(Resultat transientInstance) {
		log.debug("persisting Resultat instance");
		try {
			this.entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (final RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Resultat persistentInstance) {
		log.debug("removing Resultat instance");
		try {
			this.entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (final RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
}
