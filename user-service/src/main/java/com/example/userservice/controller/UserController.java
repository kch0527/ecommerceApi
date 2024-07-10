package com.example.userservice.controller;

import com.example.userservice.entity.UserEntity;
import com.example.userservice.response.ResUser;
import com.example.userservice.service.UserService;
import com.example.userservice.request.ReqUser;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    @Timed(value = "users.status", longTask = true)
    public String status(){
        return String.format("It's Working in User Service"
                + ", port(local.server.port)=" + environment.getProperty("local.server.port")
                + ", port(server.port)=" + environment.getProperty("server.port")
                + ", token secret=" + environment.getProperty("token.secret")
                + ", token expiration time=" + environment.getProperty("token.expiration_time"));
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
    public ResponseEntity getUser(@PathVariable String userId){
        ResUser resUsers = userService.getUserByUserId(userId);

        EntityModel entityModel = EntityModel.of(resUsers);
        WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(this.getClass()).getUsers());
        entityModel.add(webMvcLinkBuilder.withRel("all-users"));

        try {
            return ResponseEntity.status(HttpStatus.OK).body(entityModel);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @GetMapping("/users/hateoas")
    public ResponseEntity<CollectionModel<EntityModel<ResUser>>> getUserWithHateoas() {
        List<EntityModel<ResUser>> result = new ArrayList<>();
        Iterable<ResUser> users = userService.getUserByAll();

        for (ResUser user : users) {
            EntityModel entityModel = EntityModel.of(user);
            entityModel.add(linkTo(methodOn(this.getClass()).getUser(user.getUserId())).withSelfRel());

            result.add(entityModel);
        }
        return ResponseEntity.ok(CollectionModel.of(result, linkTo(methodOn(this.getClass()).getUserWithHateoas()).withSelfRel()));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<ResUser> updateUser(@PathVariable String userId, ReqUser reqUser){
        ResUser resUsers = userService.updateUser(userId, reqUser);
        return ResponseEntity.status(HttpStatus.OK).body(resUsers);
    }
}
