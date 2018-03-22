package com.redoxengine.exercise.appointments.api.repositories;

import java.util.List;
import java.util.stream.Stream;

import com.redoxengine.exercise.appointments.api.models.Appointment;
import com.redoxengine.exercise.appointments.api.models.Webhook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WebhookRepository  extends CrudRepository<Webhook, Long>{
    List<Webhook> findByCompanyName(String companyName);

    @Query("select w from Webhook w")
    Stream<Webhook> findAllAWebhooks();
}
