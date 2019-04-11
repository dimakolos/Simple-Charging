package com.netcracker.SD3_KolosDmitry.be.service.Impl;

import com.netcracker.SD3_KolosDmitry.be.entity.SubscriptionModel;
import com.netcracker.SD3_KolosDmitry.be.repository.SubscriptionRepository;
import com.netcracker.SD3_KolosDmitry.be.service.SubscriptionModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SubscriptionModelServiceImpl implements SubscriptionModelService {

    SubscriptionRepository repository;

    @Autowired
    public SubscriptionModelServiceImpl(SubscriptionRepository repository){
        this.repository = repository;
    }

    @Override
    public Iterable<SubscriptionModel> getAllSubscriptions(){ return repository.findAll(); }

    @Override
    public SubscriptionModel saveSubscription(SubscriptionModel subscriptionModel){return subscriptionModel; }

    @Override
    public void deleteSubscription(long id){}

    @Override
    public SubscriptionModel getSubscriptionById(long id){
        return repository.findById(id);
    }
}
