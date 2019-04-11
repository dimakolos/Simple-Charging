package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.SubscriptionModel;
import com.netcracker.edu.fapi.models.UserModel;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserDataService {
    List<UserModel> getAll();
    UserModel saveUser(UserModel user) throws UnsupportedEncodingException;
    void deleteBillingAccount(Long id);
    UserModel singInUser(String login, String password);
    UserModel subscribeUser(UserModel user, String id_subscription);
    List<SubscriptionModel> getUserSubscriptions(String id_user);
    UserModel unsubscribeUser(UserModel user, String id_subscription);
    UserModel updateUser(String id_user);
    UserModel addBalance(String id_user, String balance);
}
