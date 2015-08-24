package fr.eni_ecole.projet.dao;

// Generated 24 ao�t 2015 15:22:55 by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.eni_ecole.entities.ResultatSection;

/**
 * Home object for domain model class ResultatSection.
 * @see fr.eni.generated.entities.ResultatSection
 * @author Hibernate Tools
 */
@Stateless
public class ResultatSectionDaoImpl {

	private static final Log log = LogFactory.getLog(ResultatSectionDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ResultatSection transientInstance) {
		log.debug("persisting ResultatSection instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ResultatSection persistentInstance) {
		log.debug("removing ResultatSection instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ResultatSection merge(ResultatSection detachedInstance) {
		log.debug("merging ResultatSection instance");
		try {
			ResultatSection result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ResultatSection findById(int id) {
		log.debug("getting ResultatSection instance with id: " + id);
		try {
			ResultatSection instance = entityManager.find(
					ResultatSection.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
