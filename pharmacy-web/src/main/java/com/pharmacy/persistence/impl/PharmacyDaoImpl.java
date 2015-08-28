package com.pharmacy.persistence.impl;

import com.pharmacy.article.Pharmacy;
import com.pharmacy.persistence.api.PharmacyDao;
import com.pharmacy.persistence.impl.AbstractJpaDAO;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/*
 * Copyright 2015 Alexander.
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
/**
 *
 * @author Alexander
 */
@Repository
public class PharmacyDaoImpl extends AbstractJpaDAO<Pharmacy> implements PharmacyDao {

    public PharmacyDaoImpl() {
        super(Pharmacy.class);
    }

    @Override
    public Pharmacy getPharmacyByName(String name) {
        Pharmacy pharmacy = null;
        TypedQuery<Pharmacy> query = getEntityManager().createNamedQuery("findPharmacyByName", Pharmacy.class);
        query.setParameter("name", name);
        try {
            pharmacy = query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
        }
        return pharmacy;
    }

}
