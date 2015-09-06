/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.controller.abstraction;

/**
 *
 * @author Alexandr
 */
public class FilterOptions {

    private int firstPage = 1;
    private int currentPage = 1;
    private int lastPage = 10;
    private int recordsPerPage = 15;

    /**
     * @return the firstPage
     */
    public int getFirstPage() {
        return firstPage;
    }

    /**
     * @param firstPage the firstPage to set
     */
    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return the lastPage
     */
    public int getLastPage() {
        return lastPage;
    }

    /**
     * @param lastPage the lastPage to set
     */
    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    /**
     * @return the recordsPerPage
     */
    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    /**
     * @param recordsPerPage the recordsPerPage to set
     */
    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }
}
