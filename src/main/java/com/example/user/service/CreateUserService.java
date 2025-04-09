package com.example.user.service;

import com.example.user.Command;
import com.example.user.IUserRepository;
import com.example.user.model.User;
import com.example.user.model.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserService implements Command<UserDto, String> {
    private final IUserRepository iUserRepository;

    public CreateUserService(IUserRepository iUserRepository){
        this.iUserRepository = iUserRepository;
    }
    @Override
    public ResponseEntity<String> execute(UserDto input){
        User user = input.toUser();
        int id = iUserRepository.save(user).getId();
        return ResponseEntity.status(HttpStatus.OK).body(String.format("User %d, created successfully", id));
    }
}
