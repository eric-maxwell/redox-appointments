package com.redoxengine.exercise.appointments.api;

import com.redoxengine.exercise.appointments.api.models.Appointment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="callback")
public class CallbackController {

    @RequestMapping(method = RequestMethod.POST)
    public void webhookCallback(@RequestBody Appointment appointment){
        System.out.println("Updated");
    }
}

