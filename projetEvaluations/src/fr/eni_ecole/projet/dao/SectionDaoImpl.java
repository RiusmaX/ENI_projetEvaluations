package fr.eni_ecole.projet.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.eni_ecole.entities.Section;

/**
 * 
 * @author d1409sergentm
 *
 */
public class SectionDaoImpl {

	private static final Log log = LogFactory.getLog(SectionDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public Section findById(int id) {
		log.debug("getting Section instance with id: " + id);
		try {
			final Section instance = this.entityManager.find(Section.class, id);
			log.debug("get successful");
			return instance;
		} catch (final RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Section merge(Section detachedInstance) {
		log.debug("merging Section instance");
		try {
			final Section result = this.entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (final RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void persist(Section transientInstance) {
		log.debug("persisting Section instance");
		try {
			this.entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (final RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Section persistentInstance) {
		log.debug("removing Section instance");
		try {
			this.entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (final RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
}
