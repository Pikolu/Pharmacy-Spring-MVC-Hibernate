/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.article.helper;

import com.pharmacy.article.Price;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Alexandr
 */
public class ArticleHelper {

    public Price getBestDiscount(List<Price> prices) {
        Price result;
        if (prices != null && !prices.isEmpty()) {
            Collections.sort(prices, new Comparator<Price>(){

                @Override
                public int compare(Price o1, Price o2) {
                    return (o1.getDiscount() > o2.getDiscount() ? -1 : ( o1.getDiscount() == o2.getDiscount() ? 0 : 1));
                }
            });
            result = prices.get(0);
        } else {
            result = null;
        }
        return result;
    }

}
