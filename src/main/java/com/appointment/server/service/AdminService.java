package com.appointment.server.service;

import com.appointment.server.dto.ErrorResponse;
import com.appointment.server.entity.Speciality;
import com.appointment.server.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final SpecialityRepository specialityRepository;

    @Autowired
    public AdminService(SpecialityRepository specialityRepository){
        this.specialityRepository = specialityRepository;
    }

    public ResponseEntity<Object> addSpeciality(Speciality speciality){

            speciality = specialityRepository.save(speciality);
            return new ResponseEntity<>(speciality, HttpStatus.CREATED);
    }
}
