package com.challenge.invoice.service;

import com.challenge.invoice.entity.User;
import com.challenge.invoice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends AbstractService<UserRepository, User, Long>{

    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
    }

    public Optional<User> findByEmail(String email){
        return repository.findByEmail(email);
    }

    public User save(User user){
        return repository.save(user);
    }

    public List<User> findAll (){
        return repository.findAll();
    }

}
