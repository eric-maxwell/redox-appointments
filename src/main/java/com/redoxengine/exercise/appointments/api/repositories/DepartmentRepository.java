package com.redoxengine.exercise.appointments.api.repositories;

import com.redoxengine.exercise.appointments.api.models.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
