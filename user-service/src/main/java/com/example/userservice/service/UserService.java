package com.example.userservice.service;

import com.example.userservice.dto.request.ReqUser;
import com.example.userservice.dto.response.ResUser;
import com.example.userservice.jpa.UserEntity;

import java.util.List;

public interface UserService {
    ResUser createUser(ReqUser reqUser);

    ResUser getUserByUserId(String userId);

    List<ResUser> getUserByAll();
}
