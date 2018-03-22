package com.redoxengine.exercise.appointments.api.services;

import com.redoxengine.exercise.appointments.api.models.Department;
import com.redoxengine.exercise.appointments.api.models.Patient;
import com.redoxengine.exercise.appointments.api.models.Provider;
import com.redoxengine.exercise.appointments.api.repositories.DepartmentRepository;
import com.redoxengine.exercise.appointments.api.repositories.PatientRepository;
import com.redoxengine.exercise.appointments.api.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class InitService {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    ProviderRepository providerRepository;

    @PostConstruct
    public void init(){
        Department department = new Department("Department1");
        departmentRepository.save(department);
        Patient patient = new Patient("Jerry", "Jameson");
        patientRepository.save(patient);
        Provider provider = new Provider("Fred", "Flinstone");
        providerRepository.save(provider);

    }
}
