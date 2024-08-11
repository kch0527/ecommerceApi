package com.example.userservice.controller;

import com.example.userservice.entity.UserEntity;
import com.example.userservice.response.ResUser;
import com.example.userservice.service.UserService;
import com.example.userservice.request.ReqUser;
import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "회원 가입을 위한 API", description = "user-service에 회원 가입을 위한 API")
    @PostMapping("/users")
    public ResponseEntity<ResUser> createUser(@RequestBody ReqUser user){
        ResUser resUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(resUser);
    }

    @Operation(summary = "전체 사용자 목록조회 API", description = "전체 사용자 목록을 조회하기 위한 API")
    @GetMapping("/users")
    public ResponseEntity<List<ResUser>> getUsers(){
        List<ResUser> resUsers = userService.getUserByAll();
        return ResponseEntity.status(HttpStatus.OK).body(resUsers);
    }

    @Operation(summary = "사용자 정보 상세조회 API", description = "사용자에 대한 상세 정보조회를 위한 API (사용자 정보 + 주문 내역 확인)")
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

    @Operation(summary = "사용자 정보 수정을 위한 API", description = "사용자 정보 수정을 하기 위한 API")
    @PutMapping("/users/{userId}")
    public ResponseEntity<ResUser> updateUser(@PathVariable String userId, ReqUser reqUser){
        ResUser resUsers = userService.updateUser(userId, reqUser);
        return ResponseEntity.status(HttpStatus.OK).body(resUsers);
    }
}
