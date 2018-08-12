/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupoassa.gaservices.main;

import com.grupoassa.gaservices.entities.User;
import com.grupoassa.gaservices.json.GeneralResponse;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcos
 */
@RestController
public class UserController extends GenericController {

    private final String route = "/user";

    @RequestMapping(method = POST, value = route)
    public GeneralResponse createUser(@RequestBody User user) {
        return super.create(User.class,user);
    }

    @RequestMapping(method = GET, value = "/user/list")
    public List<User> listUsers() {
        return super.list(User.class);
    }

    @RequestMapping(method = PUT, value = "/user/{id}")
    public GeneralResponse updateUser(@RequestBody User user, @PathVariable Integer id) {
        return super.update(User.class, user, id);
    }

    @RequestMapping(method = DELETE, value = "/user/{id}")
    public GeneralResponse deleteUser(@PathVariable Integer id) {
        return super.delete(User.class, id);
    }

    @RequestMapping(method = GET, value = "/user/{id}")
    public User getUser(@PathVariable int id) {
        return super.get(User.class, id);

    }

    @Override
    public String getRoute() {
        return this.route;
    }
}
