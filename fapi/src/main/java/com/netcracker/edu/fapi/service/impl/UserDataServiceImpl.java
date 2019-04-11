package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.SubscriptionModel;
import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.service.UserDataService;
import com.sun.deploy.net.URLEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public UserModel singInUser(String login, String password){
        RestTemplate restTemplate = new RestTemplate();
        UserModel user =  restTemplate.getForObject(backendServerUrl + "api/userModels/signIn?login="
                + login + "&password=" + password, UserModel.class);
        return user;
    }

    @Override
    public List<UserModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserModel[] UserModelResponse =
                restTemplate.
                        getForObject(backendServerUrl + "/api/userModels/", UserModel[].class);
        return UserModelResponse ==
                null ? Collections.emptyList() : Arrays.asList(UserModelResponse);
    }



    @Override
    public UserModel saveUser(UserModel user) throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.
                postForEntity(backendServerUrl + "api/userModels", user,
                        UserModel.class).getBody();
    }

    @Override
    public void deleteBillingAccount(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/billing-accounts/" + id);
    }

    @Override
    public UserModel subscribeUser(UserModel user, String id_subscription){
        RestTemplate restTemplate = new RestTemplate();
        UserModel loguser =  restTemplate.postForEntity(backendServerUrl + "api/userModels/join?id_subscription=" + id_subscription,
                user, UserModel.class).getBody();
        return loguser;
    }

    @Override
    public List<SubscriptionModel> getUserSubscriptions(String id_user){
        RestTemplate restTemplate = new RestTemplate();
        SubscriptionModel[] SubscriptionModelResponse =
                restTemplate.
                        getForObject(backendServerUrl + "/api/userModels/user_subscriptions?id_user="
                                +id_user, SubscriptionModel[].class);
        return SubscriptionModelResponse ==
                null ? Collections.emptyList() : Arrays.asList(SubscriptionModelResponse);
    }

    @Override
    public UserModel unsubscribeUser(UserModel user, String id_subscription){
        RestTemplate restTemplate = new RestTemplate();
        UserModel loguser = restTemplate.postForEntity(backendServerUrl + "api/userModels/refuse?id_subscription="
                + id_subscription, user, UserModel.class).getBody();
        return loguser;
    }

    @Override
    public UserModel updateUser(String id_user){
        RestTemplate restTemplate = new RestTemplate();
        UserModel user = restTemplate.getForObject(backendServerUrl + "api/userModels/user_update?id_user="
                + id_user, UserModel.class);
        return user;
    }

    @Override
    public UserModel addBalance(String id_user, String balance){
        RestTemplate restTemplate = new RestTemplate();
        UserModel user = restTemplate.getForObject(backendServerUrl + "api/userModels/add_balance?id_user="
                + id_user + "&balance=" + balance, UserModel.class);
        return user;
    }
}
