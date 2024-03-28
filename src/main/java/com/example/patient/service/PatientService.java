package com.example.patient.service;

import com.example.patient.exception.ResourceNotFoundException;
import com.example.patient.model.Patient;
import com.example.patient.repo.PatientRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    private Logger log= LoggerFactory.getLogger(PatientService.class);

    public Patient savePatient(Patient patient){
       String patientId= UUID.randomUUID().toString();
       patient.setId(patientId);
       return patientRepo.save(patient);
    }

    public Patient getSinglePatient(String patientId) {
        Patient patient= patientRepo.findById(patientId).orElseThrow(()->new ResourceNotFoundException("Patient is not found with this id : "+patientId));
        return patient;
    }

    public Patient updatePatient(Patient patient, String patientId){
        Patient existingPatient= patientRepo.findById(patientId).orElseThrow(()->new ResourceNotFoundException("Patient is not found with this id : "+patientId));
        existingPatient.setName(patient.getName());
        existingPatient.setEmail(patient.getEmail());
        existingPatient.setAbout(patient.getAbout());
        return patientRepo.save(existingPatient);
    }

    @Cacheable("patients")
    public List<Patient> getAllPatient(){
        log.info("Calling Database to retrieve data : ");
        return patientRepo.findAll();
    }

    public String deletePatient(String patientId){
        patientRepo.deleteById(patientId);
        return "Patient is deleted with following Id : "+patientId;
    }
}
