package com.appointment.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    private ObjectId id;
    @DBRef
    private User user;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private LocalDate dob;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}