package com.example.userservice.controller;

import com.example.userservice.response.ResUser;
import com.example.userservice.service.UserService;
import com.example.userservice.request.ReqUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService;
    private Environment environment;

    @Autowired
    public UserController(UserService userService, Environment environment){
        this.userService = userService;
        this.environment = environment;
    }

    @GetMapping("/check")
    public String status(){
        return String.format("PORT %s", environment.getProperty("local.server.port"));
    }

    @GetMapping("/welcome")
    public String welcome(){
        return environment.getProperty("greeting.message");
    }

    @PostMapping("/users")
    public ResponseEntity<ResUser> createUser(@RequestBody ReqUser user){
        ResUser resUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(resUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResUser>> getUsers(){
        List<ResUser> resUsers = userService.getUserByAll();
        return ResponseEntity.status(HttpStatus.OK).body(resUsers);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResUser> getUsers(@PathVariable String userId){
        ResUser resUsers = userService.getUserByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(resUsers);
    }
}
