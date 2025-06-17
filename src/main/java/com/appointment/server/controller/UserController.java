package com.appointment.server.controller;


import com.appointment.server.dto.SignupReq;
import com.appointment.server.entity.User;
import com.appointment.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> signup(@RequestBody SignupReq signupReq){
        try{
            User user = new User();
            user.setName(signupReq.name());
            user.setUsername(signupReq.username());
            user.setPassword(signupReq.password());
            user.setRoles(List.of("user"));
            userRepository.save(user);
        }catch (Exception e){
            return new ResponseEntity<>("error : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("done", HttpStatus.CREATED);
    }
}
