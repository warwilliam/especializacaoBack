package com.william.usersservice.users.domain.service;

import com.william.usersservice.users.domain.model.User;
import com.william.usersservice.users.domain.repository.BillFeignClient;

import java.util.List;

public interface UserServiceInterface {

    List<User> search();
    void update(String id);
    User findByID(String id);



}
