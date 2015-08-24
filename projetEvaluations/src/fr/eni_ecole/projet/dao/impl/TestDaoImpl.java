package fr.eni_ecole.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.eni_ecole.entities.Test;

/**
 * 
 * @author d1409sergentm
 *
 */
public class TestDaoImpl {

	private static final Log log = LogFactory.getLog(TestDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public Test findById(int id) {
		log.debug("getting Test instance with id: " + id);
		try {
			final Test instance = this.entityManager.find(Test.class, id);
			log.debug("get successful");
			return instance;
		} catch (final RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Test merge(Test detachedInstance) {
		log.debug("merging Test instance");
		try {
			final Test result = this.entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (final RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void persist(Test transientInstance) {
		log.debug("persisting Test instance");
		try {
			this.entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (final RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Test persistentInstance) {
		log.debug("removing Test instance");
		try {
			this.entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (final RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
}
