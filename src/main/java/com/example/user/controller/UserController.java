package com.example.user.controller;

import com.example.user.api.UserApi;
import com.example.user.model.UpdateUserDto;
import com.example.user.model.UserDto;
import com.example.user.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController implements UserApi {
    AllUserService allUserService;
    GetUserService getUserService;
    CreateUserService createUserService;
    UpdateUserService updateUserService;
    DeleteUserServive deleteUserServive;
    UserController(AllUserService allUserService, GetUserService getUserService, CreateUserService createUserService, UpdateUserService updateUserService, DeleteUserServive deleteUserServive){
        this.allUserService = allUserService;
        this.getUserService = getUserService;
        this.createUserService = createUserService;
        this.updateUserService = updateUserService;
        this.deleteUserServive = deleteUserServive;
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserDto userDto) {
        return this.createUserService.execute(userDto);
    }
    @GetMapping
    public String obtain() {
        return "The product";
    }
    @GetMapping("all")
    public ResponseEntity<List<UserDto>> index(){
        return this.allUserService.execute(null);
    }
    @DeleteMapping
    public String delete() {
        return "Deleted";
    }
    @PutMapping("{id}")
    public ResponseEntity<UserDto> update(@PathVariable Integer id, @RequestBody UserDto userDto) {
        return this.updateUserService.execute(new UpdateUserDto(id, userDto));
    }
}
