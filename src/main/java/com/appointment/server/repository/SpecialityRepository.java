package com.appointment.server.repository;


import com.appointment.server.entity.Speciality;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends MongoRepository<Speciality, ObjectId> {
}
