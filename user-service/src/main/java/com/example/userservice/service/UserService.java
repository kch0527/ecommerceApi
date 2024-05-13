package com.example.userservice.service;

import com.example.userservice.dto.request.ReqUser;
import com.example.userservice.dto.response.ResUser;

public interface UserService {
    ResUser createUser(ReqUser reqUser);
}
