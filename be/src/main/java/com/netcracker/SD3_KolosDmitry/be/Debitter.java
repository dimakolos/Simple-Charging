package com.netcracker.SD3_KolosDmitry.be;

import com.netcracker.SD3_KolosDmitry.be.entity.SubscriptionModel;
import com.netcracker.SD3_KolosDmitry.be.entity.UserModel;
import com.netcracker.SD3_KolosDmitry.be.service.UserModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("debitter")
@EnableScheduling
public class Debitter {
    @Autowired
    UserModelService userModelService;

    @Scheduled(cron = "*/5 * * * * ?")
	public void debit(){
		List<UserModel> users = userModelService.getAllUserModel();
		for (UserModel user : users) {
			List<SubscriptionModel> subscriptions = userModelService.getUserSubscriptions(user);

			for (int i = 0; i<subscriptions.size(); i++) {
				if (user.getBalance() >= subscriptions.get(i).getCost()) {
					user.setBalance((user.getBalance() - (int) subscriptions.get(i).getCost()));
				} else {
					subscriptions.remove(subscriptions.get(i));
				}
			}
			user.setSubscriptions(subscriptions);
			userModelService.saveUserModel(user);

		}
	}
}
