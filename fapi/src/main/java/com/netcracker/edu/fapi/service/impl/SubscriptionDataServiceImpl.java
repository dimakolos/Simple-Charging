package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.SubscriptionModel;
import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.service.SubscriptionDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionDataServiceImpl implements SubscriptionDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;


    @Override
    public List<SubscriptionModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        SubscriptionModel[] SubscriptionModelResponse =
                restTemplate.
                        getForObject(backendServerUrl + "api/subcriptionsmodels", SubscriptionModel[].class);
        return SubscriptionModelResponse ==
                null ? Collections.emptyList() : Arrays.asList(SubscriptionModelResponse);
    }
}
