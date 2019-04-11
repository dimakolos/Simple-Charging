package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.SubscriptionModel;
import com.netcracker.edu.fapi.models.UserModel;
import com.netcracker.edu.fapi.service.LoginnedUserService;
import com.netcracker.edu.fapi.service.SubscriptionDataService;
import com.netcracker.edu.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private SubscriptionDataService subscriptionDataService;

    @RequestMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return ResponseEntity.ok(userDataService.getAll());

    }

    @RequestMapping("/subscriptions")
    public ResponseEntity<List<SubscriptionModel>>  getAllSubscriptions() {
        return ResponseEntity.ok(subscriptionDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel userModel /*todo server validation*/)
    throws UnsupportedEncodingException {
        if (userModel != null) {
            System.out.println("not null");
            return ResponseEntity.ok(userDataService.saveUser(userModel));
        }
        System.out.println("null");
        return null;
    }


    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public ResponseEntity<UserModel> subscribeUser(@RequestParam String id_subscription, @RequestBody UserModel user ){
        return ResponseEntity.ok(userDataService.subscribeUser(user, id_subscription));
    }

    @RequestMapping(value = "/refuse", method = RequestMethod.POST)
    public ResponseEntity<UserModel> unsubscribeUser(@RequestParam String id_subscription, @RequestBody UserModel user){
        return ResponseEntity.ok(userDataService.unsubscribeUser(user, id_subscription));
    }


    @RequestMapping(value = "/usersubscriptions", method = RequestMethod.GET)
    public ResponseEntity<List<SubscriptionModel>> getUserSubscriptions(@RequestParam String id_user){
        return ResponseEntity.ok(userDataService.getUserSubscriptions(id_user));
    }

    @RequestMapping(value = "/user_update", method = RequestMethod.GET)
    public ResponseEntity<UserModel> updateUser(@RequestParam String id_user){
        return ResponseEntity.ok(userDataService.updateUser(id_user));
    }

    @RequestMapping(value = "/add_balance", method = RequestMethod.GET)
    public ResponseEntity<UserModel> addBalance(@RequestParam(required = false) String id_user, @RequestParam(required = false) String balance){
        return ResponseEntity.ok(userDataService.addBalance(id_user, balance));
    }
}









