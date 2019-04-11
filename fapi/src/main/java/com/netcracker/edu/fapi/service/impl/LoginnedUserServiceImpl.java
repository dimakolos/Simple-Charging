package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.service.LoginnedUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginnedUserServiceImpl implements LoginnedUserService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    private UserModel loggedUser;

    @Override
    public String getLogin(){return loggedUser.getLogin();}

    @Override
    public String getPassword(){return loggedUser.getPassword();}

    @Override
    public long getBalance(){return loggedUser.getBalance();}

    @Override
    public UserModel getUserAccount(){return this.loggedUser;}

    @Override
    public void setUserAccount(UserModel user){
        this.loggedUser = user;
    }
}
