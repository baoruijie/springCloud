package com.bao.service;

import com.bao.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/13 12:44
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getLearn(){
        UserEntity user  =userService.getUserById(1);
        System.out.println(user);
        assert "章三".equals(user.getName());
    }
}
