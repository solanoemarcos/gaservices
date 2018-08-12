/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.gaservices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Marcos
 */
@Entity
@DiscriminatorValue("Employee")
public class Employee extends User {

    @JsonProperty
    private String category;
    @JsonIgnore
    private Date ingressDate;
    @JsonProperty
    private Integer points;

    public Employee() {
        super();
    }

    public Employee(Integer userDni, String name, String lastName, String email, String category, Date date, Integer points) {
        super(userDni, name, lastName, email);
        this.category = category;
        this.ingressDate = date;
        this.points = points;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getIngressDate() {
        return ingressDate;
    }

    public void setIngressDate(Date ingressDate) {
        this.ingressDate = ingressDate;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}
