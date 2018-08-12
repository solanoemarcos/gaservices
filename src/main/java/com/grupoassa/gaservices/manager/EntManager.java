/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.gaservices.manager;

import com.grupoassa.gaservices.entities.GenericEntity;
import com.grupoassa.gaservices.filters.GenericFilter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

/**
 *
 * @author Marcos
 */
public abstract class EntManager {

    protected static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("grupoassa_gaServices");
    protected static final EntityManager ENTITY_MANAGER = EMF.createEntityManager();

    /**
     *
     * @param objToPersist
     * @return
     */
    public static String persist(Object objToPersist) {
        try {
            ENTITY_MANAGER.getTransaction().begin();
            ENTITY_MANAGER.persist(objToPersist);
            ENTITY_MANAGER.getTransaction().commit();
            return "";
        } catch (PersistenceException e) {
            ENTITY_MANAGER.getTransaction().rollback();
            return e.getMessage();
        }
    }

    /**
     *
     * @param objToDelete
     * @return
     */
    public static String delete(Object objToDelete) {
        try {
            ENTITY_MANAGER.getTransaction().begin();
            ENTITY_MANAGER.remove(objToDelete);
            ENTITY_MANAGER.getTransaction().commit();
            return "";
        } catch (PersistenceException e) {
            ENTITY_MANAGER.getTransaction().rollback();
            return e.getMessage();
        }
    }

    /**
     *
     * @param <T>
     * @param arg0
     * @return
     */
    public static <T> List<T> selectAll(Class<T> arg0) {
        Query findAllQuery = ENTITY_MANAGER.createQuery("from " + arg0.getSimpleName());
        List<T> list = findAllQuery.getResultList();
        return list;
    }

    /**
     * 
     * @param <T>
     * @param arg0
     * @param filters
     * @return 
     */
    public static <T> List<T> selectOrderBy(Class<T> arg0, GenericFilter... filters){
        /* Create Criteria */
        CriteriaBuilder cb = ENTITY_MANAGER.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(arg0);
        Root<T> from = q.from(arg0);
        q.select(from);
        /* Iterate to generate an expression for each filter */
        List <Order> orderList = new ArrayList();
        for (GenericFilter filter : filters) {
            orderList.add(filter.getOrder(arg0,from,cb));
        }
        q.orderBy(orderList);
        /* Return the result */
        
        List<T> result = ENTITY_MANAGER.createQuery(q).getResultList();
        return result;
    }

    /**
     *
     * @param <T>
     * @param arg0
     * @param id
     * @return
     */
    public static <T> T select(Class<T> arg0, Integer id) {
        return ENTITY_MANAGER.find(arg0, id);
    }

    /**
     *
     * @param <T>
     * @param arg0
     * @param p
     * @param id
     * @return
     */
    public static <T extends GenericEntity> String updateById(Class<T> arg0, T p, Integer id) {
        try {
            T objectFound = ENTITY_MANAGER.find(arg0, id);
            if (objectFound != null) {
                ENTITY_MANAGER.getTransaction().begin();
                p.copyTo(objectFound);
                ENTITY_MANAGER.getTransaction().commit();
                return "";
            } else {
                return arg0.getSimpleName() + " not found.";
            }
        } catch (PersistenceException e) {
            return e.getMessage();
        }
    }

    /**
     *
     * @param <T>
     * @param arg0
     * @param id
     * @return
     */
    public static <T extends GenericEntity> String deletebyId(Class<T> arg0, Integer id) {
        T objectFound = ENTITY_MANAGER.find(arg0, id);
        if (objectFound != null) {
            return delete(objectFound);
        } else {
            return arg0.getSimpleName() + " not found.";
        }
    }
}
