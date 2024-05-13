package com.example.userservice.dto.response;

import com.example.userservice.jpa.UserEntity;
import lombok.Getter;

@Getter
public class ResUser {

    private final String email;
    private final String name;
    private final String userId;
    private final String pwd;


    public ResUser(String email, String name, String userId, String pwd) {
        this.email = email;
        this.name = name;
        this.userId = userId;
        this.pwd = pwd;
    }

    public ResUser(UserEntity userEntity){
        this.email = userEntity.getEmail();
        this.name = userEntity.getName();
        this.userId = userEntity.getUserId();
        this.pwd = userEntity.getEncryptedPwd();
    }
}
