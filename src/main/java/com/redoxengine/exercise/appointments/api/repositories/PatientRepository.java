package com.redoxengine.exercise.appointments.api.repositories;

import com.redoxengine.exercise.appointments.api.models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
}
