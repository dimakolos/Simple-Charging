package com.netcracker.edu.fapi.models;

public class LogUserModel extends UserModel {

    private LogUserModel(){}

    private static class LogUserModelHolder {
        private static final LogUserModel instance = new LogUserModel();
    }

    public static LogUserModel getInstance(){
        return LogUserModelHolder.instance;
    }

    public static void setInstance(){

    }
}
