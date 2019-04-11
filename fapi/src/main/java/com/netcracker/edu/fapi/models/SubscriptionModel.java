package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscriptionModel {
    private long idsubscription;
    private String name;
    private long cost;
    private long subscribers;
    private boolean subscribe;

    public SubscriptionModel(){}

    public SubscriptionModel(int id, String name, int cost, int subscribers, boolean subscribe){
        this.setSubscribers(id);
        this.setName(name);
        this.setCost(cost);
        this.setSubscribers(subscribers);
        this.setSubscribe(subscribe);
    }


    public String getName() {
        return name;
    }

    public long getCost() {
        return cost;
    }

    public long getSubscribers() {
        return subscribers;
    }

    public long getIdsubscription() {
        return idsubscription;
    }

    public void setIdsubscription(long idsubscription) {
        this.idsubscription = idsubscription;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public void setSubscribers(long subscribers) {
        this.subscribers = subscribers;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }
}
