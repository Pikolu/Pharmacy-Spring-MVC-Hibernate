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
package com.pharmacy.service.api;

import com.pharmacy.article.Pharmacy;
import com.pharmacy.evaluation.Evaluation;
import com.pharmacy.exception.ServiceException;
import java.util.List;

/**
 *
 * @author Alexander
 */
public interface PharmacyService {
    
    public Pharmacy getPharmacyByName(String name) throws ServiceException;

    public List<Pharmacy> findBestPharmacies() throws ServiceException;

    public List<Pharmacy> findPharmaciesByName(String pharmacyName) throws ServiceException;

    public void saveEvaluation(String pharmId, Evaluation evaluation) throws ServiceException;

    public Pharmacy getPharmacyById(String pharmId) throws ServiceException;
    
}
