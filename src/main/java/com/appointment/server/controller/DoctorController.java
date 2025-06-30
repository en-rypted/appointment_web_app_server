package com.appointment.server.controller;


import com.appointment.server.entity.Diagnosis;
import com.appointment.server.entity.Doctor;
import com.appointment.server.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
@Autowired
private DoctorService doctorService;
    @PostMapping(value = "/signup", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Object> signup(@Valid @RequestBody Doctor req){

        return doctorService.signupService(req);
    }

    @GetMapping("/todaysAppointments")
    public ResponseEntity<Object> todaysAppointments (){
        return new ResponseEntity<>("Hiiiiii !", HttpStatusCode.valueOf(200));
    }

    @GetMapping("/getDiagnosisList")
    public ResponseEntity<Object> getDiagnosisList (){
        return null;
    }

    @PostMapping("/addDiagnosis")
    public ResponseEntity<Object> addDiagnosis (@RequestBody Diagnosis diagnosis){
        return null;
    }

    @PutMapping("/editDiagnosis/{id}")
    public ResponseEntity<Object> editDiagnosis (@PathVariable String id,@RequestBody Diagnosis diagnosis){
        return null;
    }




}
