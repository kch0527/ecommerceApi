package com.example.userservice.service;

import com.example.userservice.dto.request.ReqUser;
import com.example.userservice.dto.response.ResOrder;
import com.example.userservice.dto.response.ResUser;
import com.example.userservice.jpa.UserEntity;
import com.example.userservice.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public ResUser createUser(ReqUser user) {
        UserEntity userEntity = UserEntity.builder()
                .email(user.getEmail())
                .name(user.getName())
                .userId(UUID.randomUUID().toString())
                .encryptedPwd(bCryptPasswordEncoder.encode(user.getPwd()))
                .build();
        userRepository.save(userEntity);

        ResUser resUser = ResUser.entityToRes(userEntity);
        return resUser;
    }

    @Override
    public ResUser getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);

        if(userEntity == null)
            throw new UsernameNotFoundException("User Not Found");

        ResUser resUser = ResUser.entityToRes(userEntity);

        List<ResOrder> orders = new ArrayList<>();
        resUser.setOrders(orders);

        return resUser;
    }

    @Override
    public List<ResUser> getUserByAll() {
        Iterable<UserEntity> userList = userRepository.findAll();

        List<ResUser> result = new ArrayList<>();
        userList.forEach(u -> {
            result.add(ResUser.entityToRes(u));
        });
        return result;
    }
}
