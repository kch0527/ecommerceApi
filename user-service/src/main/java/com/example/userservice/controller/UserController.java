package com.example.userservice.controller;

import com.example.userservice.dto.response.ResUser;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Greeting;
import com.example.userservice.dto.request.ReqUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Greeting greeting;


    @GetMapping("/check")
    public String status(){
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<ResUser> createUser(@RequestBody ReqUser user){
        ResUser resUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(resUser);
    }
}
