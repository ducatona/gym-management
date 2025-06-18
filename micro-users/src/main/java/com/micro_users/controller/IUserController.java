package com.micro_users.controller;

import com.micro_users.model.dto.request.UserRequest;
import com.micro_users.model.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController {

    ResponseEntity<List<UserResponse>> getAllUsers();
    ResponseEntity<UserResponse> getUserByUsername(String username);
    ResponseEntity<UserResponse> getUserById();
    ResponseEntity<UserResponse> createUser(UserRequest userRequest);
    ResponseEntity<UserResponse> updateUser(UserRequest userRequest);
    void deleteUser(String username);
}
