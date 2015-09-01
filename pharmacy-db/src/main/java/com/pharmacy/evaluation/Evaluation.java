/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pharmacy.evaluation;

import com.pharmacy.base.BaseUUID;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Alexandr
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findLastEvaluations", query = "SELECT e FROM Evaluation e ORDER BY e.creationDate DESC")
})
public class Evaluation extends BaseUUID {
    
    private float points;

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

    @Override
    public String toString() {
        return "Evaluation{" + "points=" + points + '}';
    }
    
}
