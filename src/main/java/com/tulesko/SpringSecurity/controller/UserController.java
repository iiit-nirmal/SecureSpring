package com.tulesko.SpringSecurity.controller;

import com.tulesko.SpringSecurity.model.User;
import com.tulesko.SpringSecurity.service.JWTService;
import com.tulesko.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @PostMapping("register")
    public User register(@RequestBody User user){
        return service.saveUser(user);
    }

    @PostMapping("login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user){
        Authentication authentication =
                authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        Map<String, String> response = new HashMap<>();
        if(authentication.isAuthenticated()) {
            String token = jwtService.generateToekn(user.getUsername());
            response.put("token", token);
            return ResponseEntity.ok(response);
        }
        response.put("token","Not generated");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}
