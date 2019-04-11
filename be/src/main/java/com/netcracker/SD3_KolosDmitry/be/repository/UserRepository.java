package com.netcracker.SD3_KolosDmitry.be.repository;

import com.netcracker.SD3_KolosDmitry.be.entity.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

    UserModel findByLoginAndPassword(String login, String password);
    UserModel findById(long id);
    List<UserModel> findAll();
}
