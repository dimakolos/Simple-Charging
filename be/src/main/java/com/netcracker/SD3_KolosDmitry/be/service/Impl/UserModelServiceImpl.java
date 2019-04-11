package com.netcracker.SD3_KolosDmitry.be.service.Impl;

import com.netcracker.SD3_KolosDmitry.be.entity.SubscriptionModel;
import com.netcracker.SD3_KolosDmitry.be.entity.UserModel;
import com.netcracker.SD3_KolosDmitry.be.repository.UserRepository;
import com.netcracker.SD3_KolosDmitry.be.service.UserModelService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserModelServiceImpl implements UserModelService {

    private UserRepository userRepository;

    @Autowired
    public UserModelServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserModel signInUser(String login, String password){
        UserModel user = userRepository.findByLoginAndPassword(login, password);
        return user;
    }

    @Override
    public UserModel saveUserModel(UserModel user){
        return userRepository.save(user);
    }

    @Override
    public List<UserModel> getAllUserModel(){
        return userRepository.findAll();
    }

    @Override
    public UserModel getUserModelById(long id){
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserModel(long id){
        userRepository.deleteById(id);
    }

    @Override
    public Boolean subscribeUser(Long id_user, Long id_subscription){
        Optional<UserModel> user = userRepository.findById(id_user);

        return true;
    }

    @Override
    public List<SubscriptionModel> getUserSubscriptions(UserModel user){
        return user.getSubscriptions();
    }

    @Override
    public UserModel addBalance(String id_user, String balance){
        long idUser = Long.parseLong(id_user);
        int intBalance = Integer.parseInt(balance);
        UserModel user = userRepository.findById(idUser);
        user.setBalance(user.getBalance() + intBalance);
        userRepository.save(user);
        return user;
    }
}
