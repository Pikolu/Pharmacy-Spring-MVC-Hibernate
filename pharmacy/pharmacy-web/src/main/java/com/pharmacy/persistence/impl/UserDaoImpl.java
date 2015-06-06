package com.pharmacy.persistence.impl;

import com.pharmacy.exception.PersistenceException;
import com.pharmacy.persistence.api.UserDao;
import com.pharmacy.user.User;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractJpaDAO<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User findUserByEmail(String email) throws PersistenceException {
        TypedQuery<User> query = getEntityManager().createNamedQuery("User.findUserByEmail", User.class);
        User user = query.getSingleResult();
        return user;
    }
}
