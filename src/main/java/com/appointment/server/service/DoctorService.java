package com.appointment.server.service;

import com.appointment.server.entity.Doctor;
import com.appointment.server.entity.User;
import com.appointment.server.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private DoctorRepository doctorRepository;

    public ResponseEntity<Object> signupService(Doctor doctor){
        try{
            User user = new User();
            user.setUsername(doctor.getEmail());
            user.setPassword(doctor.getName()+"@"+doctor.getMobileNo().substring(4,9));
            user.setName(doctor.getName());
            user.setRoles(List.of("doctor"));

            UserDetails userDetails = userDetailService.signup(user);
            doctorRepository.save(doctor);
            return new ResponseEntity<>(doctor,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("{\"error\" : \""+e.getMessage()+"\"}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
