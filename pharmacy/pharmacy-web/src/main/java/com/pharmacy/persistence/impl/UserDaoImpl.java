package com.pharmacy.persistence.impl;

import com.pharmacy.exception.PersistenceException;
import com.pharmacy.exception.type.ExceptionType;
import com.pharmacy.persistence.api.UserDao;
import com.pharmacy.user.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractJpaDAO<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User findUserByEmail(String email) throws PersistenceException {
        User user = null;
        try {
            Session session = getSessionFactory().openSession();
            Query query = session.getNamedQuery("User.findUserByEmail");
            query.setParameter("email", email);
            user = (User) query.uniqueResult();
        } catch (HibernateException e) {
            throw new PersistenceException(ExceptionType.LOGIN_0005, e);
        }
        return user;
    }
}
