package com.example.patient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;


@Service
public class CacheService {

    private Logger log= LoggerFactory.getLogger(CacheService.class);

    @CacheEvict(value = "patients", allEntries = true)
    public String clearPatientCache() {
       log.info("Clearing the patient cache : ");
       return "Patients Cache is Cleared : ";
    }

    @CacheEvict(allEntries = true)
    public String clearAllCaches() {
        return "All cache cleared : ";
    }
}