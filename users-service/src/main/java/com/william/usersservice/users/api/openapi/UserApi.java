package com.william.usersservice.users.api.openapi;

import com.william.usersservice.users.api.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
public interface UserApi {

    @GetMapping
    @PreAuthorize("hasRole('PROVIDERS')")
    ResponseEntity<?> search();

    @GetMapping("{id}")
    @PreAuthorize("hasRole('PROVIDERS')")
    ResponseEntity<UserResponse> findByID(@PathVariable String id);

    @PutMapping("{id}")
    ResponseEntity<?> update(@PathVariable String id);
}
