package com.micro_users.controller.impl;

import com.micro_users.controller.IUserController;
import com.micro_users.model.dto.request.UserRequest;
import com.micro_users.model.dto.response.UserResponse;
import com.micro_users.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserControllerImpl implements IUserController {

    @Autowired
    UserServiceImpl service;


    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
       return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.getUsername(username));
    }

    @Override
    public ResponseEntity<UserResponse> getUserById() {
        return null;
    }

    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public void deleteUser(String username) {

    }
}
