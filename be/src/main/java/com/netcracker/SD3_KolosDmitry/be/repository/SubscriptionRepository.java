package com.netcracker.SD3_KolosDmitry.be.repository;

import com.netcracker.SD3_KolosDmitry.be.entity.SubscriptionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<SubscriptionModel, Long> {
    SubscriptionModel findById(long id);
}
