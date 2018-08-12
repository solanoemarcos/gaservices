/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.gaservices.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Marcos
 */
@Entity(name = "Product")
public class Product extends GenericEntity {

    @Id
    @GeneratedValue
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @JsonProperty
    private Integer stock;
    @JsonProperty
    private String name;
    @JsonProperty
    private String description;
    @JsonProperty
    private Integer valuePoints;

    public Product() {
    }

    public Product(Integer stock, String name, String description, Integer valuePoints) {
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.valuePoints = valuePoints;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getValuePoints() {
        return valuePoints;
    }

    public void setValuePoints(Integer valuePoints) {
        this.valuePoints = valuePoints;
    }

    @Override
    public void copyTo(GenericEntity ge) {
        ((Product) ge).setStock(this.getStock());
        ((Product) ge).setDescription(this.getDescription());
        ((Product) ge).setValuePoints(this.getValuePoints());
        ((Product) ge).setName(this.getName());
    }

}
