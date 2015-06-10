/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.controller.abstraction;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Alexandr
 */
public abstract class AbstractController {

    private FilterOptions filterOptions;

    public void setPage(String page, ModelAndView model, int size) {
        model.addObject("noOfPages", 10);
//        if (StringUtils.isBlank(page)) {
//            model.addObject("currentPage", getFilterOptions().getCurrentPage());
//            model.addObject("firstPage", getFilterOptions().getFirstPage());
//            model.addObject("lastPage", getFilterOptions().getLastPage());
//        } else {
        int currentPage;
        if (page == null) {
            currentPage = 0;
        } else {
            currentPage = Integer.valueOf(page);
        }
        int firstPage;
        int lastPage;
        if (currentPage < 1) {
            firstPage = 1;
            int count = size / 25;
            if (count < 1) {
                lastPage = 1;
            } else if (currentPage >= 10) {
                lastPage = count;
            } else {
                lastPage = 10;

            }
        } else if (currentPage < 6) {
            firstPage = 1;
            lastPage = 10;
        } else {
            firstPage = currentPage - 5;
            lastPage = currentPage + 4;
        }
        getFilterOptions().setCurrentPage(currentPage);
        getFilterOptions().setFirstPage(firstPage);
        getFilterOptions().setLastPage(lastPage);
        
        model.addObject("currentPage", getFilterOptions().getCurrentPage());
        model.addObject("firstPage", getFilterOptions().getFirstPage());
        model.addObject("lastPage", getFilterOptions().getLastPage());
//        }
    }

    /**
     * @return the filterOptions
     */
    public FilterOptions getFilterOptions() {
        if (filterOptions == null) {
            filterOptions = new FilterOptions();
        }
        return filterOptions;
    }

    /**
     * @param filterOptions the filterOptions to set
     */
    public void setFilterOptions(FilterOptions filterOptions) {
        this.filterOptions = filterOptions;
    }
}
