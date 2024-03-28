package com.example.patient.repo;

import com.example.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, String> {
    //We can write Custom methods and native query if needed.
}

