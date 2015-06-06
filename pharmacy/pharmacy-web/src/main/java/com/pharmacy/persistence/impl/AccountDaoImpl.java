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
import com.pharmacy.persistence.api.AccountDao;
import com.pharmacy.user.Account;
import javax.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexandr
 */
@Repository
public class AccountDaoImpl extends AbstractJpaDAO<Account> implements AccountDao {
    
    private final static Logger LOG = LoggerFactory.getLogger(AccountDaoImpl.class);

    public AccountDaoImpl() {
        super(Account.class);
    }

    @Override
    public Account findAccountByEmail(String email) throws PersistenceException {
        LOG.trace("Enter findAccountByEmail: email={}", email);
        TypedQuery<Account> query = getEntityManager().createNamedQuery("Account.findAccountByEmail", Account.class);
        query.setParameter("email", email);
        Account account = query.getSingleResult();
        LOG.trace("Exit findAccountByEmail: account={}", account);
        return account;
    }

}
