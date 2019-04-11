package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UserModel;

public interface LoginnedUserService {
    String getLogin();
    String getPassword();
    long getBalance();
    UserModel getUserAccount();
    void setUserAccount(UserModel user);
}
