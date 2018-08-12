/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.gaservices.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import javax.persistence.DiscriminatorColumn;
import static javax.persistence.DiscriminatorType.STRING;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Marcos
 */
@Entity(name = "User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "User_Type", discriminatorType = STRING)
@DiscriminatorValue("Administrator")
public class User extends GenericEntity {

    @Id
    @GeneratedValue
    @JsonProperty(access = Access.READ_ONLY)
    private Integer id;
    @JsonProperty
    private Integer userDni;
    @JsonProperty
    private String name;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String email;

    public User() {
    }

    public User(Integer userDni, String name, String lastName, String email) {
        this.userDni = userDni;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }

    public Integer getUserDni() {
        return userDni;
    }

    public void setUserDni(Integer userDni) {
        this.userDni = userDni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void copyTo(GenericEntity ge) {
        ((User) ge).setEmail(this.getEmail());
        ((User) ge).setName(this.getName());
        ((User) ge).setLastName(this.getLastName());
        ((User) ge).setUserDni(this.getUserDni());
    }

}
