package com.redoxengine.exercise.appointments.api.repositories;

import com.redoxengine.exercise.appointments.api.models.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {
}
