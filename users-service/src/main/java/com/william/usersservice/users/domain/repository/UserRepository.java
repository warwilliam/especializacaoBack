package com.william.usersservice.users.domain.repository;

import com.william.usersservice.users.domain.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    void update(String id);

    User findByID(String id);

}
