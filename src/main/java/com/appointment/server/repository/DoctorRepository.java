package com.appointment.server.repository;

import com.appointment.server.entity.Doctor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, ObjectId> {
    Optional<Doctor> findByEmail(String email);
}
