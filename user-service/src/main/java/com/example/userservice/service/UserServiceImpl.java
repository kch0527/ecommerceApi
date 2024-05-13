package com.example.userservice.service;

import com.example.userservice.dto.request.ReqUser;
import com.example.userservice.dto.response.ResUser;
import com.example.userservice.jpa.UserEntity;
import com.example.userservice.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public ResUser createUser(ReqUser user) {
        UserEntity userEntity = UserEntity.builder()
                .email(user.getEmail())
                .name(user.getName())
                .userId(UUID.randomUUID().toString())
                .encryptedPwd(user.getPwd())
                .build();
        userRepository.save(userEntity);

        ResUser resUser = new ResUser(userEntity);
        return resUser;
    }
}
