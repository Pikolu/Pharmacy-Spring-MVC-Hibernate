/*
 * Copyright 2015 Alexandr.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pharmacy.persistence.impl;

import com.pharmacy.exception.PersistenceException;
import com.pharmacy.exception.type.ExceptionType;
import com.pharmacy.persistence.api.AccountDao;
import com.pharmacy.user.Account;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexandr
 */
@Repository
public class AccountDaoImpl extends AbstractJpaDAO<Account> implements AccountDao {

    public AccountDaoImpl() {
        super(Account.class);
    }

    @Override
    public Account findAccountByEmail(String email) throws PersistenceException {
        Account account = null;
//        Session session = getSessionFactory().openSession();
//        Query query = session.getNamedQuery("Account.findAccountByEmail");
//        try {
//            query.setParameter("email", email);
//            account = (Account) query.uniqueResult();
//        } catch (HibernateException e) {
//            throw new PersistenceException(ExceptionType.LOGIN_0001, e);
//            
//        }
        return account;
    }

}
