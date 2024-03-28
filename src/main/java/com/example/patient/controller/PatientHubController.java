package com.example.patient.controller;

import com.example.patient.model.Patient;
import com.example.patient.service.CacheService;
import com.example.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientHubController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private CacheService cacheService;

    @PostMapping("/save")
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }

    @GetMapping("/getSingle/{patientId}")
    public Patient getSinglePatient(@PathVariable("patientId") String patientId){
        return patientService.getSinglePatient(patientId);
    }

    @GetMapping("/getAll")
    public List<Patient> getAll(){
        return patientService.getAllPatient();
    }

    @PutMapping("/update/{patientId}")
    public Patient updateExisting(@PathVariable ("patientId") String patientId, @RequestBody Patient patient){
        return patientService.updatePatient(patient,patientId);
    }

    @DeleteMapping("/delete/{patientId}")
    public String deletepatient(@PathVariable ("patientId") String patientId){
        return patientService.deletePatient(patientId);
    }

    @GetMapping("/clear/cache")
    public String clearCache(){
        return cacheService.clearPatientCache();
    }
}
