package com.bao.controller;


import com.bao.entity.UserBorrowEntity;
import com.bao.service.BorrowService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
public class BorrowController {

    @Resource
    BorrowService borrowService;

    @RequestMapping("/borrow/{uid}")
//    @HystrixCommand(fallbackMethod = "onError")//指定备选方案。
    UserBorrowEntity findUserBorrows(@PathVariable("uid") int uid){
        return borrowService.getUserBorrowInfoByUid(uid);
    }

    UserBorrowEntity onError(int uid){
        System.out.println("补救措施，备选方案");
        return new UserBorrowEntity(null, Collections.emptyList());
    }
}
