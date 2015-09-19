package com.pharmacy.persistence.impl;

import com.pharmacy.exception.PersistenceException;
import com.pharmacy.persistence.api.UserDao;
import com.pharmacy.user.User;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
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
            TypedQuery<User> query = getEntityManager().createNamedQuery("User.findUserByEmail", User.class);
            query.setParameter("email", email);
             user = query.getSingleResult();
        } catch (NoResultException e) {
            //TODO do nothing
        }

        return user;
    }

    @Override
    public User findUserById(String id) throws PersistenceException {
        User user = super.findOne(id);
        return user;
    }
}
