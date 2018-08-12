/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.gaservices.entities;

import java.io.Serializable;

/**
 *
 * @author Marcos
 */
public abstract class GenericEntity implements Serializable{
    
    /**
     * 
     * @param ge 
     */
    public abstract void copyTo(GenericEntity ge);
}
