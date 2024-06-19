package com.example.userservice.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserEditor {

    private String name;
    private String encryptedPwd;

    @Builder
    public UserEditor(String name, String encryptedPwd){
        this.name = name;
        this.encryptedPwd = encryptedPwd;
    }
}
