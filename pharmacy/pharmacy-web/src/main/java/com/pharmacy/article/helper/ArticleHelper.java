/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.article.helper;

import com.pharmacy.article.Price;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Alexandr
 */
public class ArticleHelper {

    public Price getBestDiscount(List<Price> prices) {
        Price result;
        if (prices != null && !prices.isEmpty()) {
            Collections.sort(prices);
            result = prices.get(0);
        } else {
            result = null;
        }
        return result;
    }

}
