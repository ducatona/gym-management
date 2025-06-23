package com.micro_users.service.impl;

import com.micro_users.mapper.UserMapper;
import com.micro_users.model.dto.request.UserRequest;
import com.micro_users.model.dto.response.UserResponse;
import com.micro_users.repository.IUserRepository;
import com.micro_users.repository.Role;
import com.micro_users.repository.User;
import com.micro_users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    PasswordEncoder passwordEncoder;
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
        return mapper.toResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {

        if(repository.findByUsername(userRequest.getUsername()) != null){
            System.out.println("aqui va una excepcion personalizada");
        }

        User newUser = new User();
        newUser.setUsername(userRequest.getUsername());
        newUser.setEmail(userRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        newUser.setRole(Role.USER);


        return mapper.toResponse(newUser);

    }

    @Override
    public void deleteUser(Long idUser) {

        User userFound =  repository.findById(idUser).orElseThrow();
        repository.deleteById(userFound.getId());

    }
}
