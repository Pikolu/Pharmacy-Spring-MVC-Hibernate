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
package com.pharmacy.evaluation.helper;

import com.pharmacy.evaluation.Evaluation;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Alexander
 */
@Component
public class EvaluationValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Evaluation.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Evaluation evaluation = (Evaluation) target;
        
        String name = evaluation.getName();
        String description = evaluation.getDescription();
        
        if (name.length() > 255) {
            errors.rejectValue("name", "label.nameGreaterThan255");
        }
        if (description.length() > 4000) {
            errors.rejectValue("description", "label.descriptionGreaterThan4000");
        }
        
    }
    
}
