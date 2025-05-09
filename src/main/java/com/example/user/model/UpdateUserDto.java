package com.example.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateUserDto {
    private final Integer id;
    private final UserDto userDto;
}
