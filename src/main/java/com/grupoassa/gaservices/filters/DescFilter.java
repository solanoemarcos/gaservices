/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.gaservices.filters;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

/**
 *
 * @author Marcos
 */
public class DescFilter extends GenericFilter{
    
    private final String column;
    
    public DescFilter(String column){
        this.column = column;
    }

    @Override
    public <T> Order getOrder(Class<T> arg0, Root<T> from, CriteriaBuilder cq) {
        return cq.desc(from.get(this.column));
    }
    
}
