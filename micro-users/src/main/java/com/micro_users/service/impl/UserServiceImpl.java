package com.micro_users.service.impl;

import com.micro_users.mapper.UserMapper;
import com.micro_users.model.dto.request.UserRequest;
import com.micro_users.model.dto.response.UserResponse;
import com.micro_users.repository.IUserRepository;
import com.micro_users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    IUserRepository repository;
    @Autowired
    UserMapper mapper;


    @Override
    public List<UserResponse> getAllUsers() {
        return mapper.toResponseList(repository.findAll());
    }

    @Override
    public UserResponse getUsername(String username) {
        return mapper.toResponse(repository.findByUsername(username));
    }

    @Override
    public UserResponse getUserById(Long id) {
        return null;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public void deleteUser(Long idUser) {

    }
}
