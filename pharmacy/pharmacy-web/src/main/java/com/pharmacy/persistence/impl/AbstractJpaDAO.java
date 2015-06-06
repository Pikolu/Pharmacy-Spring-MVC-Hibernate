package com.pharmacy.persistence.impl;

import com.pharmacy.base.BaseUUID;
import com.pharmacy.exception.PersistenceException;
import java.util.Date;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractJpaDAO<T extends BaseUUID> {
    
    private final static Logger LOG = LoggerFactory.getLogger(AbstractJpaDAO.class);

    private Class<T> clazz;

    @PersistenceContext(unitName = "PharmacyUnit")
    private EntityManager entityManager;

    AbstractJpaDAO(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(final long id) throws PersistenceException {
        LOG.trace("Enter findOne: id={}", id);
        T result = entityManager.find(clazz, id);
        LOG.trace("Exit findOne: result={}", result);
        return result;
    }

    public List<T> findAll() throws PersistenceException {
        LOG.trace("Enter findAll");
        Query query = entityManager.createQuery("SELECT t FROM " + clazz.getName() + " t");
        List<T> result = query.getResultList();
        LOG.trace("Exit findAll: result size={}", result.size());
        return result;
    }

    public void create(final T entity) throws PersistenceException {
        LOG.trace("Enter create: entity={}", entity);
        entity.setLastUpdated(new Date());
        entityManager.persist(entity);
        LOG.trace("Exit create");
    }

    public T save(final T entity) throws PersistenceException {
        LOG.trace("Enter save: entity={}", entity);
        entity.setLastUpdated(new Date());
        T result = entityManager.merge(entity);
        LOG.trace("Exit save: result={}", result);
        return result;
    }

    public void delete(final T entity) throws PersistenceException {
        LOG.trace("Enter delete: entity={}", entity);
        entityManager.remove(entity);
        LOG.trace("Exit delete");
    }

    public void deleteById(final long entityId) throws PersistenceException {
        LOG.trace("Enter deleteById: entityId={}", entityId);
        final T entity = findOne(entityId);
        delete(entity);
        LOG.trace("Exit deleteById");
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * @param entityManager the entityManager to set
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
