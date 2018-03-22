package com.redoxengine.exercise.appointments.api;

import com.redoxengine.exercise.appointments.api.models.Webhook;
import com.redoxengine.exercise.appointments.api.repositories.WebhookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/webhooks")
public class WebhookController {

    private WebhookRepository webhookRepository;

    @Autowired
    public WebhookController(WebhookRepository webHookRepository) {
        super();
        this.webhookRepository = webHookRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Webhook addWebHook(@RequestBody Webhook webhook){
        List<Webhook> webhooks = webhookRepository.findByCompanyName(
                webhook.getCompanyName());
        if(webhooks != null && webhooks.contains(webhook)){
            return webhook;
        }
        webhookRepository.save(webhook);
        return webhook;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Webhook> getAllWebHooks(){
        List<Webhook> webhooks = new ArrayList<>();
        webhookRepository.findAll().iterator().forEachRemaining(webhooks::add);
        return webhooks;
    }
}
