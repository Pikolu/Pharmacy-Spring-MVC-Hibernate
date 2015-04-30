/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.evaluation;

import com.pharmacy.base.BaseUUID;
import javax.persistence.Entity;

/**
 *
 * @author Alexandr
 */
@Entity
public class Evaluation extends BaseUUID {
    
    private String title;
    private String description;
    private float points;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the points
     */
    public float getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(float points) {
        this.points = points;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "title=" + title + ", description=" + description + ", points=" + points + '}';
    }
    
}
