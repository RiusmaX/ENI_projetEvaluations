package fr.eni_ecole.projet.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.eni.entities.Utilisateur;

/**
 * 
 * @author d1409sergentm
 *
 */
public class UtilisateurDao {

	private static final Log log = LogFactory.getLog(UtilisateurDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	public Utilisateur findById(int id) {
		log.debug("getting Utilisateur instance with id: " + id);
		try {
			final Utilisateur instance = this.entityManager.find(
					Utilisateur.class, id);
			log.debug("get successful");
			return instance;
		} catch (final RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Utilisateur merge(Utilisateur detachedInstance) {
		log.debug("merging Utilisateur instance");
		try {
			final Utilisateur result = this.entityManager
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (final RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void persist(Utilisateur transientInstance) {
		log.debug("persisting Utilisateur instance");
		try {
			this.entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (final RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Utilisateur persistentInstance) {
		log.debug("removing Utilisateur instance");
		try {
			this.entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (final RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
}
