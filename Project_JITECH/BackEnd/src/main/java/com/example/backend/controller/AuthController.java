package com.example.backend.controller;

import com.example.backend.model.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5174") 
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if (request.getEmail().equals("admin@example.com") &&
            request.getPassword().equals("123456")) {
            return "LOGIN_SUCCESS";
        }

        return "INVALID_CREDENTIALS";
    }
}
