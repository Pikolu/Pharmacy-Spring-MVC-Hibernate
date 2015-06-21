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

    private static final int PAGE_COUNT = 10;

    private FilterOptions filterOptions;

    public void setPage(String page, ModelAndView model, Long size) {
        int currentPage;
        int firstPage;
        int lastPage;
        int count;

        if (page == null) {
            currentPage = 1;
        } else {
            currentPage = Integer.valueOf(page);
        }

        if (page == null) {
            firstPage = 1;
            count = getPageCount(size);
            lastPage = getLastPage(count, PAGE_COUNT);
        } else {
            if (currentPage > 6) {
                firstPage = currentPage - 4;
                count = getPageCount(size);
                lastPage = getLastPage(count, currentPage + 5);
            } else {
                firstPage = 1;
                count = getPageCount(size);
                lastPage = getLastPage(count, PAGE_COUNT);
            }
        }
        getFilterOptions().setCurrentPage(currentPage);
        getFilterOptions().setFirstPage(firstPage);
        getFilterOptions().setLastPage(lastPage);
        model.addObject("currentPage", getFilterOptions().getCurrentPage());
        model.addObject("firstPage", getFilterOptions().getFirstPage());
        model.addObject("lastPage", getFilterOptions().getLastPage());
    }

    private int getLastPage(int count, int result) {
        if (count <= result) {
            return (count < 1) ? 1 : count;
        } else {
            return result;
        }
    }

    private int getPageCount(Long size) {
        int result = (int) (size / filterOptions.getRecordsPerPage());
        return result;
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
