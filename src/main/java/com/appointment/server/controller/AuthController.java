package com.appointment.server.controller;


import com.appointment.server.dto.LoginReq;
import com.appointment.server.dto.SignupReq;
import com.appointment.server.entity.User;
import com.appointment.server.repository.UserRepository;
import com.appointment.server.service.JwtService;
import com.appointment.server.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/home")
    public String home(){
        return "Hi bro";
    }

    @PostMapping(value = "/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> signup(@RequestBody SignupReq signupReq){
        UserDetails userDetails = null;
        try{
            User user = new User();
            user.setName(signupReq.name());
            user.setUsername(signupReq.username());
            user.setPassword(signupReq.password());
            user.setRoles(List.of("user"));
             userDetails = userDetailService.signup(user);
        }catch (Exception e){
            return new ResponseEntity<>("error : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(userDetails, HttpStatus.CREATED);
    }

    @PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> signup(@RequestBody LoginReq loginReq){

        try{

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                    = new UsernamePasswordAuthenticationToken(loginReq.username(),loginReq.password());

            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            UserDetails userDetails = userDetailService.loadUserByUsername(loginReq.username());
            String token = jwtService.getJwtToken(userDetails.getUsername());
            return new ResponseEntity<>(String.format("{\"token\":\"%s\"}",token), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>("error : "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
