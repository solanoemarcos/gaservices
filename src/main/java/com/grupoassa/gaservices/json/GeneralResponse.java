/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.gaservices.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Marcos
 */
public class GeneralResponse {
    @JsonProperty
    private String url;
    @JsonProperty
    private String method;
    @JsonProperty
    private String status;
    @JsonProperty
    private String message;
    
    public GeneralResponse(String url, String method, String status){
        this.url = url;
        this.method = method;
        this.status = status;
        this.message = "";
    }
    
    public GeneralResponse(String url, String method, String status, String error){
        this.url = url;
        this.method = method;
        this.status = status;
        this.message = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
