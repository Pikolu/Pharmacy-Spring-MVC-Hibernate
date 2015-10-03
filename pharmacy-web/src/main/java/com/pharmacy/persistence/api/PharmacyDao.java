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
package com.pharmacy.persistence.api;

import com.pharmacy.article.Pharmacy;
import com.pharmacy.evaluation.Evaluation;
import com.pharmacy.exception.PersistenceException;
import java.util.List;

/**
 *
 * @author Alexander
 */
public interface PharmacyDao {

    public Pharmacy getPharmacyByName(String name) throws PersistenceException;

    public List<Pharmacy> findBestPharmacies() throws PersistenceException;

    public List<Pharmacy> findPharmaciesByName(String pharmacyName) throws PersistenceException;

    public Pharmacy getPharmacyById(String pharmId) throws PersistenceException;

    public void savePharmacy(Pharmacy pharmacy) throws PersistenceException;

    public void saveEvaluation(String pharmId, Evaluation evaluation) throws PersistenceException;
}
