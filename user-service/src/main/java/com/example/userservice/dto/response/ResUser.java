package com.example.userservice.dto.response;

import com.example.userservice.jpa.UserEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResUser {

    private final String email;
    private final String name;
    private final String userId;
    private final String pwd;

    private List<ResOrder> orders;


    public ResUser(String email, String name, String userId, String pwd) {
        this.email = email;
        this.name = name;
        this.userId = userId;
        this.pwd = pwd;
    }

    public static ResUser entityToRes(UserEntity userEntity) {
        return new ResUser(userEntity.getEmail(), userEntity.getName(), userEntity.getUserId(), userEntity.getEncryptedPwd());
    }

}
