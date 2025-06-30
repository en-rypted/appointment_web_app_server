package com.appointment.server.repository;


import com.appointment.server.entity.Diagnosis;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends MongoRepository<Diagnosis, ObjectId> {
}
