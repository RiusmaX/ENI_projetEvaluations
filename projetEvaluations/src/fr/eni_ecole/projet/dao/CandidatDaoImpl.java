package fr.eni_ecole.projet.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.eni_ecole.entities.Candidat;

/**
 * 
 * @author d1409sergentm
 *
 */
public class CandidatDaoImpl {

	private static final Log log = LogFactory.getLog(CandidatDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public Candidat findById(int id) {
		log.debug("getting Candidat instance with id: " + id);
		try {
			final Candidat instance = this.entityManager.find(Candidat.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (final RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Candidat merge(Candidat detachedInstance) {
		log.debug("merging Candidat instance");
		try {
			final Candidat result = this.entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (final RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void persist(Candidat transientInstance) {
		log.debug("persisting Candidat instance");
		try {
			this.entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (final RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Candidat persistentInstance) {
		log.debug("removing Candidat instance");
		try {
			this.entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (final RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
}
