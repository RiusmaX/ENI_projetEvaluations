package fr.eni_ecole.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.eni_ecole.entities.SessionTest;

/**
 * 
 * @author d1409sergentm
 *
 */
public class SessionTestDaoImpl {

	private static final Log log = LogFactory.getLog(SessionTestDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public SessionTest findById(int id) {
		log.debug("getting SessionTest instance with id: " + id);
		try {
			final SessionTest instance = this.entityManager.find(
					SessionTest.class, id);
			log.debug("get successful");
			return instance;
		} catch (final RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public SessionTest merge(SessionTest detachedInstance) {
		log.debug("merging SessionTest instance");
		try {
			final SessionTest result = this.entityManager
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (final RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void persist(SessionTest transientInstance) {
		log.debug("persisting SessionTest instance");
		try {
			this.entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (final RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(SessionTest persistentInstance) {
		log.debug("removing SessionTest instance");
		try {
			this.entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (final RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
}
