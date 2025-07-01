package com.appointment.server.controller;

import com.appointment.server.entity.Speciality;
import com.appointment.server.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("/addSpeciality")
    public ResponseEntity<Object> addSpeciality(@Valid @RequestBody Speciality speciality){
        return adminService.addSpeciality(speciality);
    }
}
