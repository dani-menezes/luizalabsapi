package com.luizalabs.api.common;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Common Methods to Data Access Object Design Pattern
 * @author danielmenezes
 *
 * @param <E>
 */
public abstract class AbstractDAO<E extends CommonBean> implements CommonDAO<E> {
	
	/** Instance Logger. */
	private final Logger logger = LogManager.getLogManager().getLogger(AbstractDAO.class.getName());

	/** Default UID serial version. */
	private static final long serialVersionUID = 1L;

	/** {@link EntityManagerFactory} para acesso ao banco de dados. */
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("API_PU");
	
	/** {@link EntityManager} */
	private EntityManager em = null;

	/**
	 * Return the entityManager
	 */
	protected EntityManager getEntityManager() {
		if (em == null) {
			em = emf.createEntityManager();
		}
		return em;
	}

	/**
	 * Recupera a classe da entidade.
	 * @return Class
	 */
	protected abstract Class<E> getEntityClass();
	
	/**
	 * {@inheritDoc}.
	 */
	public E saveOrUpdate(E entity) {
		EntityTransaction transaction = getEntityManager().getTransaction();
		E persisted = null;
		try {
			transaction.begin();

            persisted = em.merge(entity);

			transaction.commit();
		} catch (Exception e) {
			this.logger.severe("Error Saving Entity: " + e.getMessage());
			transaction.rollback();
		}
		
		return persisted;
	}
	
	/**
	 * {@inheritDoc}.
	 */
	public void delete(E entity) {
        EntityTransaction transaction = getEntityManager().getTransaction();
        if (entity != null && entity.getId() != null) {
        	try {
        		transaction.begin();
        		
        		E entityPersisted = em.find(this.getEntityClass(), entity.getId());
        		
        		if(entityPersisted == null) {
        			this.logger.info("Error Deleting Entity: Entity not found");
        		}
        		else {
        			em.remove(entityPersisted);
        		}
        		
        		transaction.commit();
        	} catch (Exception e) {
        		this.logger.severe("Error Deleting Customer: " + e.getMessage());
        		transaction.rollback();
        	}
        }
	}

	/**
	 * Retrieve the entity filtred by id and companyId
	 * @param entityId Entity ID
	 * @param companyId Company ID
	 * @return Entity
	 */
	public E find (Integer id) {
		E entity = null;

		try {
			entity = getEntityManager().find(this.getEntityClass(), id);
		} catch (Exception e) {
			this.logger.severe("Error retriving Entity: " + e.getMessage());
		}
		return entity;
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		List<E> entityList = new ArrayList<E>();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT entity ");
			sql.append("  FROM ").append(getEntityClass().getSimpleName()).append(" entity ");
			entityList =  getEntityManager().createQuery(sql.toString()).getResultList();
		} catch (Exception e) {
			this.logger.severe("Error retriving Entities: " + e.getMessage());
		}
		return entityList;
	}
}
