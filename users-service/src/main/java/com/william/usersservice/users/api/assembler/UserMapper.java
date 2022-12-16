package com.william.usersservice.users.api.assembler;

import com.william.usersservice.users.api.dto.UserResponse;
import com.william.usersservice.users.domain.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toResponse(User user);
}
