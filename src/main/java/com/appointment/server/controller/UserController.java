package com.appointment.server.controller;

import com.appointment.server.entity.Appointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getSpecialityList")
    public ResponseEntity<Object> getSpecialityList() {
        return null;
    }

    @GetMapping("/getDoctorsBySpeciality/{id}")
    public ResponseEntity<Object> getDoctorsBySpeciality(@PathVariable String id ){
        return  null;
    }

    @GetMapping("/getAllAppointments")
    public ResponseEntity<Object> getAllAppointments(){
        return  null;
    }

    @GetMapping("/getAppointmentDetails/{appointmentId}")
    public ResponseEntity<Object> getAppointmentDetails(@PathVariable String appointmentId ){
        return  null;
    }

    @PostMapping("/bookAppointment")
    public ResponseEntity<Object> bookAppointment(@RequestBody Appointment appointment){
        return  null;
    }

    @PutMapping("/editAppointment/{appointmentId}")
    public ResponseEntity<Object> editAppointment(@PathVariable String appointmentId ){
        return  null;
    }

    @DeleteMapping("/cancelAppointment/{appointmentId}")
    public ResponseEntity<Object> cancelAppointment(@PathVariable String appointmentId ){
        return  null;
    }
}
