package com.bao.controller;

import com.bao.service.TransactionService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/13 16:16
 */

@RestController
public class TransactionController {

    @Resource
    private TransactionService service;

    @RequestMapping("/update")
    public Map transactionTest(HttpServletRequest request){
        System.out.println("update==> " + request.getRequestURL());
        Map map = new HashMap<>();
        map.put("name","包炜");
        map.put("mobile","15990572573");
        return map;
//        return "牛逼！！！！";
    }
}
