package com.pharmacy.persistence.impl;

import com.pharmacy.base.BaseUUID;
import com.pharmacy.exception.PersistenceException;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractJpaDAO<T extends BaseUUID> {

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
        T result = entityManager.find(clazz, id);
        return result;
    }

    public List<T> findAll() throws PersistenceException {
        Query query = entityManager.createQuery("SELECT t FROM " + clazz.getName() + " t");
        List<T> result = query.getResultList();
        return result;
    }

    public void create(final T entity) throws PersistenceException {
        entityManager.persist(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public T save(final T entity) throws PersistenceException {
        T result = entityManager.merge(entity);
        return result;
    }

    public void delete(final T entity) throws PersistenceException {
        entityManager.remove(entity);
    }

    public void deleteById(final long entityId) throws PersistenceException {
        final T entity = findOne(entityId);
        delete(entity);
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
