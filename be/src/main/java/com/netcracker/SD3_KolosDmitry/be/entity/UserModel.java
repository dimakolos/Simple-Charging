package com.netcracker.SD3_KolosDmitry.be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String login;
    private String password;
    private int balance;

    public UserModel(){}

    public UserModel(int id, String login, String password, int balance){
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
        this.setBalance(balance);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_subscriptions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id")
    )
    private List<SubscriptionModel> subscriptions;

    public List<SubscriptionModel> getSubscriptions(){
        return subscriptions;
    }

    public void setSubscriptions(List<SubscriptionModel> subscriptions){
        this.subscriptions = subscriptions;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


}
