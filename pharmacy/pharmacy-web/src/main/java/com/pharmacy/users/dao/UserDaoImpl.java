package com.pharmacy.users.dao;

import com.pharmacy.user.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(unitName = "PharmacyUnit")
    private EntityManager entityManager;

    private EntityManagerFactory entityManagerFactory;
    
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public User findUserByEmail(String email) {
        User user = null;
//        Session session = getSessionFactory().openSession();
        TypedQuery<User> query = getEntityManager().createNamedQuery("User.findUserByEmail", User.class);
        query.setParameter("email", email);
        try {
            user = query.getSingleResult();
        } catch (Exception e) {
            //do nothing
        }

        return user;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void save(User user) {
        
//        Session session = getSessionFactory().openSession();
//        EntityTransaction tx = getEntityManager().getTransaction();
//        tx.begin();
        getEntityManager().merge(user);
        getEntityManager().flush();
//        tx.commit();
//        session.flush();
    }

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
        if (entityManager == null) {
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    /**
     * @param entityManager the entityManager to set
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * @return the entityManagerFactory
     */
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    /**
     * @param entityManagerFactory the entityManagerFactory to set
     */
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
