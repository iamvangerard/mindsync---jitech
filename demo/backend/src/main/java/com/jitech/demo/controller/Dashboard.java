package com.jitech.demo.controller;

import com.jitech.demo.model.LoginRequest;
import com.jitech.demo.model.User;
import com.jitech.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class Dashboard {

    private final UserRepository userRepository;

    public Dashboard(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signIn")
    public String singIn(@RequestBody LoginRequest temp){
        User user = userRepository.findByUsername(temp.getUsername());

        if(user==null){return "USER NOT FOUND";}

        if(user.getPassword().equals(temp.getPassword())){return "LOGIN SUCCESSFULLY";}
        else{return "WRONG PASSWORD";}
    }
}
