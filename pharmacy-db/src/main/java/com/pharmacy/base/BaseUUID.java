package com.pharmacy.base;

import org.apache.commons.lang.StringUtils;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.annotations.Index;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Alexandr
 */
@MappedSuperclass
public abstract class BaseUUID implements Serializable {

    @Id
    @Column(length = 36, name = "id")
    private String id;
    @Index
    private String name;
    @Index
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date creationDate;

    public BaseUUID() {
    }

    /**
     * @param id
     */
    public void setId(String id) {
        if (StringUtils.isBlank(this.id)) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("It is not allowed to change an existing id!");
        }
    }

    /**
     * @return id
     */
    public String getId() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
        return id;
    }

    @PrePersist
    protected void onPersist() {
        if (StringUtils.isBlank(this.id)) {
            this.id = UUID.randomUUID().toString();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseUUID other = (BaseUUID) obj;
        return !((this.id == null) ? (other.id != null) : !this.id.equals(other.id));
    }

    /**
     * @return the Hashcode for this entity
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * @return the lastUpdated
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

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
}
