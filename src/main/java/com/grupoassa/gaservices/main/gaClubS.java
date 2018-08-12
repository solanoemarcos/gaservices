/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.gaservices.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author Marcos
 */
@SpringBootApplication
@ComponentScan("com.grupoassa.gaservices")
public class gaClubS {

    public static void main(String[] args) {
        SpringApplication.run(gaClubS.class, args);
//        Employee e = new Employee(35829356, "Marcos", "Solano", "solano.e.marcos@gmail.com", "no se", new Date(), 1600);
//        try {
//            System.out.println(new ObjectMapper().writeValueAsString(e));
//        } catch (JsonProcessingException ex) {
//            Logger.getLogger(gaClubS.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
