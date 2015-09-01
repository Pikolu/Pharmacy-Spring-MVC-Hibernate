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

import com.pharmacy.evaluation.Evaluation;
import com.pharmacy.persistence.api.EvaluationDao;
import com.pharmacy.service.api.EvaluationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alexander
 */
@Service
public class EvaluationServiceImpl implements EvaluationService {
    
    @Autowired
    private EvaluationDao evaluationDao;

    @Override
    public List<Evaluation> getLastEvaluations() {
        return evaluationDao.getLastEvaluations();
    }
    
}
