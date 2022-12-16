package com.william.usersservice.users.domain.repository;

import com.william.usersservice.infraestruture.configuration.openfeign.KeycloakInterceptorConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.cloud.openfeign.FeignClient;


import java.util.List;

@FeignClient(name = "users-claims-service", url = "http://localhost:8081", configuration = KeycloakInterceptorConfiguration.class)
public interface BillFeignClient {

    @GetMapping
    ResponseEntity<List<String>> buscarTudo();
    @GetMapping
    ResponseEntity<String> buscar();
    @PostMapping
    void setarFatura();

}
