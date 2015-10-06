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
package com.pharmacy.service.impl;

import com.pharmacy.article.Pharmacy;
import com.pharmacy.evaluation.Evaluation;
import com.pharmacy.exception.PersistenceException;
import com.pharmacy.exception.ServiceException;
import com.pharmacy.persistence.api.PharmacyDao;
import com.pharmacy.service.api.PharmacyService;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alexander
 */
@Service
public class PharmacyServiceImpl implements PharmacyService {

    private static final Logger LOG = LoggerFactory.getLogger(PharmacyServiceImpl.class);

    private PharmacyDao pharmacyDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Pharmacy getPharmacyByName(String name) throws ServiceException {
        Pharmacy pharmacy = null;
        try {
            pharmacy = getPharmacyDao().getPharmacyByName(name);
        } catch (PersistenceException ex) {
            ex.writeLog(LOG);
            throw ex;
        }
        return pharmacy;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Pharmacy> findBestPharmacies() throws ServiceException {
        List<Pharmacy> pharmacies;
        try {
            pharmacies = getPharmacyDao().findBestPharmacies();
        } catch (PersistenceException ex) {
            ex.writeLog(LOG);
            throw ex;
        }
        return pharmacies;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Pharmacy> findPharmaciesByName(String pharmacyName) throws ServiceException {
        List<Pharmacy> pharmacies;
        try {
            pharmacies = getPharmacyDao().findPharmaciesByName(pharmacyName);
        } catch (PersistenceException ex) {
            ex.writeLog(LOG);
            throw ex;
        }
        return pharmacies;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveEvaluation(String pharmId, Evaluation evaluation) throws ServiceException {
        try {
            calculateTotalEvaluation(evaluation);            
            pharmacyDao.saveEvaluation(pharmId, evaluation);
        } catch (PersistenceException ex) {
            ex.writeLog(LOG);
            throw ex;
        }
    }

    @Override
    public Pharmacy getPharmacyById(String pharmId) throws ServiceException {
        Pharmacy pharmacy = null;
        try {
            pharmacy = getPharmacyDao().getPharmacyById(pharmId);
        } catch (PersistenceException ex) {
            ex.writeLog(LOG);
            throw ex;
        }
        return pharmacy;
    }

    /**
     * @return the pharmacyDao
     */
    public PharmacyDao getPharmacyDao() {
        return pharmacyDao;
    }

    /**
     * @param pharmacyDao the pharmacyDao to set 
     */
    public void setPharmacyDao(PharmacyDao pharmacyDao) {
        this.pharmacyDao = pharmacyDao;
    }

    private void calculateTotalEvaluation(Evaluation evaluation) {
        evaluation.setPoints((float)(evaluation.getDescriptionPoints() + evaluation.getShippingPoints() + evaluation.getShippingPricePoints()) / 3);
    }

}
