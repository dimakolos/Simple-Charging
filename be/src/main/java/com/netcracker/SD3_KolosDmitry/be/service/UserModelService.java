package com.netcracker.SD3_KolosDmitry.be.service;

import com.netcracker.SD3_KolosDmitry.be.entity.SubscriptionModel;
import com.netcracker.SD3_KolosDmitry.be.entity.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserModelService {
    UserModel saveUserModel(UserModel user);
    List<UserModel> getAllUserModel();
    UserModel getUserModelById(long id);
    void deleteUserModel(long id);
    UserModel signInUser(String login, String password);
    Boolean subscribeUser(Long id_user, Long id_subscription);
    List<SubscriptionModel> getUserSubscriptions(UserModel user);
    UserModel addBalance(String id_user, String balance);
}
