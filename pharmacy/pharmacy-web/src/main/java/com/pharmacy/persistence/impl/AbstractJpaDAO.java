package com.pharmacy.persistence.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractJpaDAO<T extends Serializable> {

    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;
    
    AbstractJpaDAO(final Class<T> clazzToSet)  {
        this.clazz = clazzToSet;
    }

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(final long id) {
        return getEntityManager().find(clazz, id);
    }
    
    public List<T> findAll() {
        return getEntityManager().createQuery("from " + clazz.getName()).getResultList();
    }

    public void create(final T entity) {
        getEntityManager().persist(entity);
    }

    public T save(final T entity) {
        return getEntityManager().merge(entity);
    }

    public void delete(final T entity) {
        getEntityManager().remove(entity);
    }

    public void deleteById(final long entityId) {
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