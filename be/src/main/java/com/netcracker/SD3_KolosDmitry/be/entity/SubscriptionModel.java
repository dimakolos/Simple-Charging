package com.netcracker.SD3_KolosDmitry.be.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subscriptions")
public class SubscriptionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idsubscription;
    private String name;
    private long cost;
    private long subscribers;

    public SubscriptionModel(){}

    public SubscriptionModel(int id, String name, long cost, int subscribers){
        this.setIdsubscription(id);
        this.setName(name);
        this.setCost(cost);
        this.setSubscribers(subscribers);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_subscriptions",
            joinColumns = @JoinColumn(name = "subscription_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )

    public long getIdsubscription() {
        return idsubscription;
    }

    public void setIdsubscription(long idsubscription) {
        this.idsubscription = idsubscription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(long subscribers) {
        this.subscribers = subscribers;
    }
}
