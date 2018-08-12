/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.gaservices.main;

import com.grupoassa.gaservices.entities.GenericEntity;
import com.grupoassa.gaservices.filters.GenericFilter;
import com.grupoassa.gaservices.json.GeneralResponse;
import com.grupoassa.gaservices.manager.EntManager;
import java.util.List;

/**
 *
 * @author Marcos
 */
public abstract class GenericController {

    public static final String ERROR_STATUS = "Error";
    public static final String SUCCESS_STATUS = "Success";

    public abstract String getRoute();

    public <T extends GenericEntity> GeneralResponse create(Class<T> arg0, T o) {
        String error = EntManager.persist(o);
        if (error.isEmpty()) {
            return new GeneralResponse(this.getRoute(), "POST", SUCCESS_STATUS);
        } else {
            return new GeneralResponse(this.getRoute(), "POST", ERROR_STATUS, error);
        }
    }

    public <T extends GenericEntity> List<T> list(Class<T> arg0) {
        return EntManager.selectAll(arg0);
    }
    
    public <T extends GenericEntity> List<T> getProductsByFilter(Class<T> arg0, GenericFilter... filters){
        return EntManager.selectOrderBy(arg0, filters);
    }

    public <T extends GenericEntity> GeneralResponse update(Class<T> arg1, T o, Integer id) {
        String error = EntManager.updateById(arg1, o, id);

        if (error.isEmpty()) {
            return new GeneralResponse(this.getRoute() + "/" + id, "POST", SUCCESS_STATUS);
        } else {
            return new GeneralResponse(this.getRoute() + "/" + id, "POST", ERROR_STATUS, error);
        }
    }

    public <T extends GenericEntity> GeneralResponse delete(Class<T> arg0, Integer id) {
        String error = EntManager.deletebyId(arg0, id);
        if (error.isEmpty()) {
            return new GeneralResponse(this.getRoute() + "/" + id, "DELETE", SUCCESS_STATUS);
        } else {
            return new GeneralResponse(this.getRoute() + "/" + id, "DELETE", ERROR_STATUS, error);
        }
    }

    public <T extends GenericEntity> T get(Class<T> arg0, Integer id) {
        return EntManager.select(arg0, id);

    }
}
