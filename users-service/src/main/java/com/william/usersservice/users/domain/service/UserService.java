package com.william.usersservice.users.domain.service;

import com.william.usersservice.users.domain.repository.BillFeignClient;
import org.springframework.stereotype.Service;

@Service
public class UserService{
private final BillFeignClient cliente;

    public UserService(BillFeignClient cliente){ this.cliente = cliente; }
}
