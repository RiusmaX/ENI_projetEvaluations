package fr.eni_ecole.projet.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.eni_ecole.entities.Question;

/**
 * 
 * @author d1409sergentm
 *
 */
public class QuestionDaoImpl {

	private static final Log log = LogFactory.getLog(QuestionDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public Question findById(int id) {
		log.debug("getting Question instance with id: " + id);
		try {
			final Question instance = this.entityManager.find(Question.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (final RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Question merge(Question detachedInstance) {
		log.debug("merging Question instance");
		try {
			final Question result = this.entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (final RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void persist(Question transientInstance) {
		log.debug("persisting Question instance");
		try {
			this.entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (final RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Question persistentInstance) {
		log.debug("removing Question instance");
		try {
			this.entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (final RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
}
