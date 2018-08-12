/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.gaservices.filters;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

/**
 *
 * @author Marcos
 */
public abstract class GenericFilter {

    /**
     * 
     * @param <T>
     * @param arg0
     * @param from
     * @param cb
     * @return 
     */
    public abstract <T> Order getOrder(Class<T> arg0, Root<T> from, CriteriaBuilder cb);
}
