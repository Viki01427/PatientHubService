package com.example.patient.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="patient_hub")
public class Patient {

    @Id
    @Column(name="PATIENT_ID")
    private String id;
    @Column(name="PATIENT_NAME")
    private String name;
    @Column(name="PATIENT_EMAIL")
    private String email;
    @Column(name="PATIENT_ADDRESS")
    private String about;

}
