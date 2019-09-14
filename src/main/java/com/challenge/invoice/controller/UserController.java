package com.challenge.invoice.controller;

import com.challenge.invoice.entity.User;
import com.challenge.invoice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@RestController
public class UserController {

    private UserService service;

    @PostMapping("/user")
    public User save( @RequestBody User user){
        return service .save(user);
    }

    @GetMapping("/user")
    public List<User> findAll (){
        return service.findAll();
    }

    @GetMapping("/user/{email}")
    public User findByEmail(@PathVariable String email){
        return service.findByEmail(email).orElse(null);
    }
}
