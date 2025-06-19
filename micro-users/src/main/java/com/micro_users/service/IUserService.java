package com.micro_users.service;

import com.micro_users.model.dto.request.UserRequest;
import com.micro_users.model.dto.response.UserResponse;
import com.micro_users.repository.User;

import java.util.List;

public interface IUserService {

    List<UserResponse> getAllUsers();
    UserResponse getUsername(String username);
    UserResponse getUserById(Long id);
    UserResponse createUser(UserRequest userRequest);
    void deleteUser(Long idUser);

}
