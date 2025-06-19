package com.appointment.server.controller;


import com.appointment.server.entity.Doctor;
import com.appointment.server.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
@Autowired
private DoctorService doctorService;
    @PostMapping(value = "/signup", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Object> signup(@Valid @RequestBody Doctor req){

        return doctorService.signupService(req);
    }


}
