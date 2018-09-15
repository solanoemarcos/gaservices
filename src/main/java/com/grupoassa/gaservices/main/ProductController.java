/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.gaservices.main;

import com.grupoassa.gaservices.entities.Product;
import com.grupoassa.gaservices.filters.AscFilter;
import com.grupoassa.gaservices.json.GeneralResponse;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcos
 */
@RestController
public class ProductController extends GenericController {

    private final String route = "/product";

    @RequestMapping(method = POST, value = route)
    public GeneralResponse createProduct(@RequestBody Product prod) {
        return super.create(Product.class, prod);
    }

    @RequestMapping(method = GET, value = route + "/list")
    public List<Product> listProduct() {
        return super.list(Product.class);
    }

    @RequestMapping(method = PUT, value = route + "/{id}")
    public GeneralResponse updateProduct(@RequestBody Product p, @PathVariable Integer id) {
        return super.update(Product.class, p, id);
    }

    @RequestMapping(method = DELETE, value = route + "/{id}")
    public GeneralResponse deleteUser(@PathVariable Integer id) {
        return super.delete(Product.class, id);
    }

    @RequestMapping(method = GET, value = route + "/{id}")
    public Product getUser(@PathVariable int id) {
//        return UserEntityManager.select(User.class, id);
        return super.get(Product.class, id);
    }

    @RequestMapping(method = GET, value = route + "/list/{columns}")
    public List<Product> getProductsBy(@PathVariable String[] columns) {
        AscFilter[] listFilters= new AscFilter[columns.length];
        for(int i = 0;i < columns.length ; i++){
           listFilters[i]= new AscFilter(columns[i]); 
        }
        return super.getProductsByFilter(Product.class, listFilters);
    }

    @ExceptionHandler(Exception.class)
    public GeneralResponse handleError(HttpServletRequest req, Exception ex) {
        return new GeneralResponse(req.getRequestURL().toString(), req.getMethod(), ERROR_STATUS, ex.getMessage());
    }

    @Override
    public String getRoute() {
        return this.route;
    }
}
