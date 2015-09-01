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
package com.pharmacy.persistence.impl;

import com.pharmacy.evaluation.Evaluation;
import com.pharmacy.persistence.api.EvaluationDao;
import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alexander
 */
@Repository
public class EvaluationDaoImpl extends AbstractJpaDAO<Evaluation> implements EvaluationDao {

    public EvaluationDaoImpl() {
        super(Evaluation.class);
    }

    @Override
    public List<Evaluation> getLastEvaluations() {
        TypedQuery<Evaluation> query = getEntityManager().createNamedQuery("findLastEvaluations", Evaluation.class);
        query.setMaxResults(5);
        List<Evaluation> evaluations = query.getResultList();
        return evaluations;
    }

}
