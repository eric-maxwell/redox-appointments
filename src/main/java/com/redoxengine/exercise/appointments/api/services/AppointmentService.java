package com.redoxengine.exercise.appointments.api.services;

        import com.redoxengine.exercise.appointments.api.models.Appointment;
        import com.redoxengine.exercise.appointments.api.repositories.AppointmentRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import org.springframework.transaction.annotation.Transactional;

        import java.time.LocalDateTime;
        import java.util.List;
        import java.util.stream.Collectors;
        import java.util.stream.Stream;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    WebhookService webhookService;

    public Appointment saveAppointment(Appointment appointment) throws Exception {

        if(appointment.getId() != null) {
           Appointment appt =  appointmentRepository.findById(appointment.getId()).get();
           if(appt.getStartDateTime().isBefore(LocalDateTime.now())) throw new Exception("Cannot update appointment that started in the past");
        }

        if(appointment.getStartDateTime().isBefore(LocalDateTime.now()))
            throw new Exception("Start date and time of an appointment cannot be in the past.");
        if(appointment.getStartDateTime().isAfter(appointment.getEndDateTime()))
            throw new Exception("Start date and time of an appointment cannot be after the End date and time of the appointment.");

        webhookService.callHooks(appointment);
        return appointmentRepository.save(appointment);
    }

    public Appointment getAppointment(Long id){
       return appointmentRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Appointment> getAppointments(){
        Stream<Appointment> appointmentsStream  =  appointmentRepository.findAllAppointments();
        return appointmentsStream
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Appointment> getAppointments(LocalDateTime start, LocalDateTime end){
        Stream<Appointment> appointmentsStream  =  appointmentRepository.findAllAppointmentsInRange(start, end);
        return appointmentsStream
                .collect(Collectors.toList());
    }
}
