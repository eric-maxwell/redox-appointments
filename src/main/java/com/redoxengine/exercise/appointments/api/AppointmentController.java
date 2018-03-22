package com.redoxengine.exercise.appointments.api;

import com.redoxengine.exercise.appointments.api.models.Appointment;
import com.redoxengine.exercise.appointments.api.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value="appointments")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;


    @RequestMapping(value="/", method=RequestMethod.GET)
    public @ResponseBody
    List<Appointment> getAppointments(){
        return appointmentService.getAppointments();
    }

    @RequestMapping(value="/{start}/{end}", method=RequestMethod.GET)
    public @ResponseBody
    List<Appointment> getAppointments(@PathVariable("start") String start, @PathVariable("end") String end){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(start, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(end, formatter);
        return appointmentService.getAppointments(startDateTime, endDateTime);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public @ResponseBody Appointment getAppointment(@PathVariable("id") Long id){
        return appointmentService.getAppointment(id);
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public @ResponseBody Appointment createAppointment(@RequestBody Appointment appointment) throws Exception{

        return appointmentService.saveAppointment(appointment);
    }

    //TODO -- Add PATCH implementation
   /*@RequestMapping(value="/{id}", method=RequestMethod.PATCH)
    public String patchAppointment(@PathVariable("id") String id, Appointment appointment){
    }*/

    @RequestMapping(value="/", method=RequestMethod.PUT)
    public @ResponseBody Appointment putAppointment(@RequestBody Appointment appointment) throws Exception {
       return appointmentService.saveAppointment(appointment);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteAppointment(@PathVariable("id") String id){
        return "Yay";
    }
}
