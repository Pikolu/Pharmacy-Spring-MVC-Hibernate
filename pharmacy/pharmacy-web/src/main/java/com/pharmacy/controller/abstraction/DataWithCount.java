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
package com.pharmacy.controller.abstraction;

import com.pharmacy.base.BaseUUID;
import java.util.List;

/**
 *
 * @author Alexandr
 * @param <T>
 */
public class DataWithCount<T extends BaseUUID> {
    
    private Long count;
    private List<T> resultList;

    /**
     * @return the count
     */
    public Long getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * @return the resultList
     */
    public List<T> getResultList() {
        return resultList;
    }

    /**
     * @param resultList the resultList to set
     */
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    @Override
    public String toString() {
        return "DataWithCount{" + "count=" + count + ", resultList=" + resultList + '}';
    }
    
}
