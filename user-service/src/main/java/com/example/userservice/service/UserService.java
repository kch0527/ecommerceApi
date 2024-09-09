package com.example.userservice.service;

import com.example.userservice.request.ReqPwCheck;
import com.example.userservice.request.ReqUser;
import com.example.userservice.response.ResPwCheck;
import com.example.userservice.response.ResUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    ResUser createUser(ReqUser reqUser);

    ResUser getUserByUserId(String userId);

    List<ResUser> getUserByAll();

    ResUser getUserDetailsByEmail(String userName);

    ResUser updateUser(String userId, ReqUser reqUser);

    ResPwCheck checkPassword(ReqPwCheck reqPwCheck);
}
