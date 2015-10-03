package com.pharmacy.persistence.impl;

import com.pharmacy.article.Pharmacy;
import com.pharmacy.base.BaseUUID_;
import com.pharmacy.evaluation.Evaluation;
import com.pharmacy.exception.PersistenceException;
import com.pharmacy.persistence.api.PharmacyDao;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class PharmacyDaoImpl extends AbstractJpaDAO<Pharmacy> implements PharmacyDao {

    public PharmacyDaoImpl() {
        super(Pharmacy.class);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Pharmacy getPharmacyByName(String name) {
        Pharmacy pharmacy = null;
        TypedQuery<Pharmacy> query = getEntityManager().createNamedQuery("findPharmacyByName", Pharmacy.class);
        query.setParameter("name", name);
        try {
            pharmacy = query.getSingleResult();
        } catch (NoResultException | NonUniqueResultException e) {
            //TODO do nothing
        }
        return pharmacy;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Pharmacy> findBestPharmacies() {
        TypedQuery<Pharmacy> query = getEntityManager().createNamedQuery("findBestPharmacies", Pharmacy.class);
        query.setMaxResults(5);
        return query.getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public List<Pharmacy> findPharmaciesByName(String pharmacyName) {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Pharmacy> query = builder.createQuery(Pharmacy.class);
        Root<Pharmacy> root = query.from(Pharmacy.class);
        Expression<String> lowerName = builder.lower(root.get(BaseUUID_.name));
        Predicate predicate = builder.like(lowerName, "%" + pharmacyName.toLowerCase() + "%");
        query.where(predicate);
        query.select(root);
        TypedQuery<Pharmacy> sqlQuery = getEntityManager().createQuery(query);
        return sqlQuery.getResultList();
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public Pharmacy getPharmacyById(String pharmId) throws PersistenceException {
        Pharmacy pharmacy = super.findOne(Integer.valueOf(pharmId));
        return pharmacy;
    }    

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void savePharmacy(Pharmacy pharmacy) throws PersistenceException {
        super.save(pharmacy);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void saveEvaluation(String pharmId, Evaluation evaluation) throws PersistenceException {
        Pharmacy pharmacy = findOne(Integer.valueOf(pharmId));
        pharmacy.getEvaluations().add(evaluation);
        super.save(pharmacy);
    }
}
