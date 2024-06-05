package com.example.userservice.controller;

import com.example.userservice.response.ResUser;
import com.example.userservice.service.UserService;
import com.example.userservice.request.ReqUser;
import com.example.userservice.vo.Greeting;
import io.micrometer.core.annotation.Timed;
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

    @Autowired
    private Greeting greeting;

    @GetMapping("/check")
    @Timed(value = "users.status", longTask = true)
    public String status(){
        return String.format("It's Working in User Service"
                + ", port(local.server.port)=" + environment.getProperty("local.server.port")
                + ", port(server.port)=" + environment.getProperty("server.port")
                + ", gateway ip(env)=" + environment.getProperty("gateway.ip")
                + ", token secret=" + environment.getProperty("token.secret")
                + ", token expiration time=" + environment.getProperty("token.expiration_time"));
    }

    @GetMapping("/welcome")
    @Timed(value = "users.welcome", longTask = true)
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
