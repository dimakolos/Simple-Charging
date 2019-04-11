package com.netcracker.edu.fapi.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel {
    private int id;
    private String login;
    private String password;
    private int balance;
    private List<SubscriptionModel> subscriptions;

    public UserModel(){}


    public UserModel(int id, String login, String password, int balance, List<SubscriptionModel> subscriptions){
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
        this.setBalance(balance);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SubscriptionModel> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<SubscriptionModel> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
