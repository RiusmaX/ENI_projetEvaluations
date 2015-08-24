package fr.eni_ecole.projet.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.eni_ecole.entities.Theme;

/**
 * 
 * @author d1409sergentm
 *
 */
public class ThemeDaoImpl {

	private static final Log log = LogFactory.getLog(ThemeDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public Theme findById(int id) {
		log.debug("getting Theme instance with id: " + id);
		try {
			final Theme instance = this.entityManager.find(Theme.class, id);
			log.debug("get successful");
			return instance;
		} catch (final RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Theme merge(Theme detachedInstance) {
		log.debug("merging Theme instance");
		try {
			final Theme result = this.entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (final RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void persist(Theme transientInstance) {
		log.debug("persisting Theme instance");
		try {
			this.entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (final RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Theme persistentInstance) {
		log.debug("removing Theme instance");
		try {
			this.entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (final RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
}
