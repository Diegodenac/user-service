package com.example.user.service;

import com.example.user.IUserRepository;
import com.example.user.Query;
import com.example.user.model.User;
import com.example.user.model.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllUserService implements Query<Void, List<UserDto>> {
    private final IUserRepository iUserRepository;
    AllUserService(IUserRepository iUserRepository){
        this.iUserRepository = iUserRepository;
    }
    @Override
    public ResponseEntity<List<UserDto>> execute(Void input){
        List<User> users = iUserRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users.stream().map(UserDto::new).toList());
    }
}
