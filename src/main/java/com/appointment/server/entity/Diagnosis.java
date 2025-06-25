package com.appointment.server.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "diagnosis")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diagnosis {
    @Id
    private String id;

    @DBRef
    private Appointment appointment;

    @DBRef
    private Doctor doctor;

    @DBRef
    private User user;

    private String diagnosis;

    private List<Prescription> prescription;

    private String notes;
    private List<String> testsRecommended;
    private LocalDate followUpDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
