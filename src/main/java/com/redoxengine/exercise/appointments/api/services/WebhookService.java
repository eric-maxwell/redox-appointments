package com.redoxengine.exercise.appointments.api.services;

import com.redoxengine.exercise.appointments.api.models.Appointment;
import com.redoxengine.exercise.appointments.api.models.Webhook;
import com.redoxengine.exercise.appointments.api.repositories.WebhookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WebhookService {

    @Autowired
    WebhookRepository webhookRepository;


    @Transactional(readOnly = true)
    public List<Webhook> getWebhooks(){
        Stream<Webhook> webhooksStream  =  webhookRepository.findAllAWebhooks();
        return webhooksStream
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public void callHooks(Appointment appointment){

        List<Webhook> hooks = getWebhooks();
        for (Webhook hook: hooks) {
            RestTemplate restTemplate = new RestTemplate();
            Appointment result = restTemplate.postForObject(hook.getUrl(), appointment, Appointment.class);
        }
    }
}
