package com.pharmacy.persistence.impl;

import com.pharmacy.base.BaseUUID;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.hibernate.Transaction;

public abstract class AbstractJpaDAO<T extends BaseUUID> {

    private Class<T> clazz;

    @Autowired
    private SessionFactory sessionFactory;

    AbstractJpaDAO(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(final long id) {
        Session session = sessionFactory.openSession();
        return (T) session.load(clazz, id);
    }

    public List<T> findAll() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from " + clazz.getName()).list();
    }

    public void create(final T entity) {
        Session session = sessionFactory.openSession();
        Transaction tx2 = session.beginTransaction();
        session.persist(entity);
        tx2.commit();
        session.close();
    }

    public T save(final T entity) {
        Session session = sessionFactory.openSession();
        Transaction tx2 = session.beginTransaction();
        T result = (T) session.merge(entity);
        tx2.commit();
        session.close();
        return result;
    }

    public void delete(final T entity) {
        Session session = sessionFactory.openSession();
        Transaction tx2 = session.beginTransaction();
        session.delete(entity);
        tx2.commit();
        session.close();
    }

    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
