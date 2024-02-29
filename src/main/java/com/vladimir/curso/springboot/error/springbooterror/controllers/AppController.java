package com.vladimir.curso.springboot.error.springbooterror.controllers;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vladimir.curso.springboot.error.springbooterror.exceptions.UserNotFoundException;
import com.vladimir.curso.springboot.error.springbooterror.models.domain.User;
import com.vladimir.curso.springboot.error.springbooterror.services.UserService;


@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping
    public String index(){
        // int value = 100/0;
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return " Ok 200";
    }

    @GetMapping("/showuser/{id}")
    public User showUser(@PathVariable(name = "id") Long id) {
        User user = service.findByiD(id).orElseThrow(() -> new UserNotFoundException("Error, el usuario no existe!"));
        ////if (user==null){                                                                    //! Esto se resuelve con el API Optional
        ////    throw new UserNotFoundException("Error, el usuario no existe!"); 
        ////}
        System.out.println(user.getLastname());
        return user;
    }

    /*@GetMapping("/showuser/{id}")   //? Otra manera de resolver el error con 404 Not Found
    public ResponseEntity<?> showUser(@PathVariable(name = "id") Long id) {
        Optional<User> optionalUser = service.findByiD(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalUser.orElseThrow());
    }*/
    
}

