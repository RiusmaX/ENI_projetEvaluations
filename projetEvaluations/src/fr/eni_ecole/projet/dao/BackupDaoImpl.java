package fr.eni_ecole.projet.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.eni_ecole.entities.Backup;

/**
 * 
 * @author d1409sergentm
 *
 */
public class BackupDaoImpl {

	private static final Log log = LogFactory.getLog(BackupDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	public Backup findById(int id) {
		log.debug("getting Backup instance with id: " + id);
		try {
			final Backup instance = this.entityManager.find(Backup.class, id);
			log.debug("get successful");
			return instance;
		} catch (final RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Backup merge(Backup detachedInstance) {
		log.debug("merging Backup instance");
		try {
			final Backup result = this.entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (final RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void persist(Backup transientInstance) {
		log.debug("persisting Backup instance");
		try {
			this.entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (final RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Backup persistentInstance) {
		log.debug("removing Backup instance");
		try {
			this.entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (final RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
}
