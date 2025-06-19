package com.micro_users.mapper;

import com.micro_users.model.dto.response.UserResponse;
import com.micro_users.repository.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toResponse(User user);
    List<UserResponse> toResponseList(List<User> userList);
}
