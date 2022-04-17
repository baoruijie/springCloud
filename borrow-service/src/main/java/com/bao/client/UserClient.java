package com.bao.client;


import com.bao.clientImpl.UserClientImpl;
import com.bao.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(value="user-service",fallback = UserClientImpl.class)
public interface UserClient {

    @RequestMapping("/user/{id}")
    UserEntity findUserById(@PathVariable("id")int id);
}
