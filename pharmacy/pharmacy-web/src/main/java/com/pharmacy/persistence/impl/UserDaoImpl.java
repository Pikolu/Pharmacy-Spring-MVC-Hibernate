package com.pharmacy.persistence.impl;

import com.pharmacy.persistence.api.UserDao;
import com.pharmacy.user.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractJpaDAO<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User findUserByEmail(String username) {
        User user = null;
        try {
            Session session = getSessionFactory().openSession();
            Query query = session.getNamedQuery("User.findUserByEmail");
            user = (User) query.uniqueResult();
//            TypedQuery<User> query = getEntityManager().createNamedQuery("User.findUserByEmail", User.class);
//            query.getSingleResult();
        } catch (Exception e) {
            //do nothing
        }
        return user;
    }
}
