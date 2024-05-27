package com.example.userservice.service;

import com.example.userservice.client.OrderServiceClient;
import com.example.userservice.request.ReqUser;
import com.example.userservice.response.ResOrder;
import com.example.userservice.response.ResUser;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    Environment environment;

    OrderServiceClient orderServiceClient;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, Environment environment, OrderServiceClient orderServiceClient){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.environment = environment;
        this.orderServiceClient = orderServiceClient;
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

        List<ResOrder> orderList = orderServiceClient.getOrders(userId);
        resUser.setOrders(orderList);

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserEntity userEntity = userRepository.findByEmail(username);

       if(userEntity == null) throw new UsernameNotFoundException(username);

       return new User(userEntity.getEmail(), userEntity.getEncryptedPwd(),
               true, true, true, true, new ArrayList<>());
    }

    @Override
    public ResUser getUserDetailsByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) throw new UsernameNotFoundException(email);

        ResUser resUser = ResUser.entityToRes(userEntity);
        return resUser;
    }
}
