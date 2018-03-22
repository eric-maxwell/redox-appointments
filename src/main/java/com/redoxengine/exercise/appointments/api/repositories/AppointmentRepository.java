package com.redoxengine.exercise.appointments.api.repositories;

import com.redoxengine.exercise.appointments.api.models.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    @Query("select a from Appointment a")
    Stream<Appointment> findAllAppointments();

    @Query("select a from Appointment a WHERE startDateTime BETWEEN :start AND :end")
    Stream<Appointment> findAllAppointmentsInRange(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}

