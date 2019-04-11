package com.netcracker.SD3_KolosDmitry.be.service;

import com.netcracker.SD3_KolosDmitry.be.entity.SubscriptionModel;

import java.util.Optional;

public interface SubscriptionModelService {
    Iterable<SubscriptionModel>getAllSubscriptions();
    SubscriptionModel saveSubscription(SubscriptionModel subscriptionModel);
    void deleteSubscription(long id);
    SubscriptionModel getSubscriptionById(long id);
}
