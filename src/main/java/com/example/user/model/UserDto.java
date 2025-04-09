package com.example.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private String email;
    private String cellPhone;
    public UserDto(){}
    public UserDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.cellPhone = user.getCellPhone();
    }
    public User toUser(){
        var user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setCellPhone(this.cellPhone);
        return user;
    }
}
