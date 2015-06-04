package com.pharmacy.persistence.impl;

import com.pharmacy.base.BaseUUID;
import com.pharmacy.exception.PersistenceException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Transaction;

public abstract class AbstractJpaDAO<T extends BaseUUID> {

    private Class<T> clazz;

//    @Autowired
//    private SessionFactory sessionFactory;
    
    @PersistenceContext(unitName = "PharmacyUnit")
    private EntityManager entityManager;

    AbstractJpaDAO(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }
//
//    public final void setClazz(final Class<T> clazzToSet) {
//        this.clazz = clazzToSet;
//    }
//
//    public T findOne(final long id) throws PersistenceException {
//        Session session = sessionFactory.openSession();
//        return (T) session.load(clazz, id);
//    }
//
//    public List<T> findAll() throws PersistenceException {
//        Session session = sessionFactory.openSession();
//        return session.createQuery("from " + clazz.getName()).list();
//    }
//
//    public void create(final T entity) throws PersistenceException {
//        Session session = sessionFactory.openSession();
//        Transaction tx2 = session.beginTransaction();
//        session.persist(entity);
//        tx2.commit();
//        session.close();
//    }
//
    public T save(final T entity) throws PersistenceException {
        
        T result = entityManager.merge(entity);
        entityManager.flush();
//        Session session = sessionFactory.openSession();
//        Transaction tx2 = session.beginTransaction();
//        T result = (T) session.merge(entity);
//        entity.setLastUpdated(new Date());
//        tx2.commit();
//        session.close();
        return result;
    }
//
//    public void delete(final T entity) throws PersistenceException {
//        Session session = sessionFactory.openSession();
//        Transaction tx2 = session.beginTransaction();
//        session.delete(entity);
//        tx2.commit();
//        session.close();
//    }
//
//    public void deleteById(final long entityId) throws PersistenceException {
//        final T entity = findOne(entityId);
//        delete(entity);
//    }
//
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

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
