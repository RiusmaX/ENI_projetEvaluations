package fr.eni_ecole.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.eni_ecole.entities.Reponse;

/**
 * 
 * @author d1409sergentm
 *
 */
public class ReponseDaoImpl {

	private static final Log log = LogFactory.getLog(ReponseDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public Reponse findById(int id) {
		log.debug("getting Reponse instance with id: " + id);
		try {
			final Reponse instance = this.entityManager.find(Reponse.class, id);
			log.debug("get successful");
			return instance;
		} catch (final RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Reponse merge(Reponse detachedInstance) {
		log.debug("merging Reponse instance");
		try {
			final Reponse result = this.entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (final RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void persist(Reponse transientInstance) {
		log.debug("persisting Reponse instance");
		try {
			this.entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (final RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Reponse persistentInstance) {
		log.debug("removing Reponse instance");
		try {
			this.entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (final RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
}
