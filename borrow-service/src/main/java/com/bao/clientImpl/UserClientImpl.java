package com.bao.clientImpl;

import com.bao.client.UserClient;
import com.bao.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient {
    @Override
    public UserEntity findUserById(int id) {
        UserEntity user = new UserEntity();
        user.setName("feign 方式实现补救措施。。");
        return user;
    }
}
