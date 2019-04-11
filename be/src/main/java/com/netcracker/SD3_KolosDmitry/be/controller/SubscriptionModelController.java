package com.netcracker.SD3_KolosDmitry.be.controller;

import com.netcracker.SD3_KolosDmitry.be.entity.SubscriptionModel;
import com.netcracker.SD3_KolosDmitry.be.service.SubscriptionModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subcriptionsmodels")
public class SubscriptionModelController {

    private SubscriptionModelService subscriptionModelService;

    @Autowired
    public SubscriptionModelController(SubscriptionModelService subscriptionModelService){
        this.subscriptionModelService = subscriptionModelService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<SubscriptionModel> getAllSubscriptions() {
        return subscriptionModelService.getAllSubscriptions();
    }
}
