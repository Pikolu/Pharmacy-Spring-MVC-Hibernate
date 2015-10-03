/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.category;

import com.pharmacy.base.BaseUUID;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexandr
 */
@Entity
@Table(name = "category")
@NamedQueries({
    @NamedQuery(name = "findAllCategories", query = "SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.children"),
    @NamedQuery(name = "Category.findCategory", query = "SELECT c FROM Category c LEFT JOIN FETCH c.children WHERE c.id = :id"),
    @NamedQuery(name = "Category.findChildren", query = "SELECT c FROM Category c WHERE c.children = :parent_id"),
    @NamedQuery(name = "Category.firstCategory", query = "SELECT c FROM Category c LEFT JOIN FETCH c.children WHERE c.name = :name")})
public class Category extends BaseUUID {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", nullable = true)
    @OrderColumn
    private List<Category> children = new LinkedList<>();
    private String directoryName;

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    /**
     * @return the directoryName
     */
    public String getDirectoryName() {
        return directoryName;
    }

    /**
     * @param directoryName the directoryName to set
     */
    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    @Override
    public String toString() {
        return "Category{" + "children=" + children + ", directoryName=" + directoryName + '}';
    }
    
    
}
