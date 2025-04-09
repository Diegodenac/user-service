package com.example.user.service;

import com.example.user.Command;
import com.example.user.IUserRepository;
import com.example.user.model.UpdateUserDto;
import com.example.user.model.User;
import com.example.user.model.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserService implements Command<UpdateUserDto, UserDto> {
    private final IUserRepository iUserRepository;

    UpdateUserService(IUserRepository iUserRepository){
        this.iUserRepository = iUserRepository;
    }
    @Override
    public ResponseEntity<UserDto> execute(UpdateUserDto input){
        Optional<User> user =iUserRepository.findById(input.getId());
        if(user.isPresent()){
            user.get().setName(input.getUserDto().getName());
            user.get().setEmail(input.getUserDto().getEmail());
            user.get().setCellPhone(input.getUserDto().getCellPhone());
            return ResponseEntity.status(HttpStatus.OK).body(new UserDto(iUserRepository.save(user.get())));
        }
        return null;
    }
}
