package com.william.usersservice.users.api.controller;

import com.william.usersservice.users.api.assembler.UserMapper;
import com.william.usersservice.users.api.dto.UserResponse;
import com.william.usersservice.users.api.openapi.UserApi;
import com.william.usersservice.users.domain.model.User;
import com.william.usersservice.users.domain.repository.BillFeignClient;
import com.william.usersservice.users.domain.service.UserServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController implements UserApi {
    private final UserServiceInterface userService;

    private final BillFeignClient cliente;

    private final UserMapper mapper;

    public UserController(UserServiceInterface userService, BillFeignClient cliente, UserMapper mapper) {
        this.userService = userService;
        this.cliente = cliente;
        this.mapper = mapper;

    }

    @GetMapping
    public ResponseEntity<String> getUser(){ return ResponseEntity.ok("William" + cliente.buscar().getBody()); }

    @Override
    public ResponseEntity<?> search() {
        List<User> allUsers = userService.search();
        final var response = allUsers.stream().map(mapper::toResponse).toList();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserResponse> findByID(String id) {
        User user = userService.findByID(id);
        UserResponse response = mapper.toResponse(user);
        return ResponseEntity.ok(response);
    }


    @Override
    public ResponseEntity<?> update(String id) {
        userService.update(id);
        return ResponseEntity.ok().build();
    }
}

