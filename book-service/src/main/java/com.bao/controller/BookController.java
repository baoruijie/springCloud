package com.bao.controller;


import com.bao.entity.BookEntity;
import com.bao.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class BookController {


    @Resource
    private BookService bookService;


    @RequestMapping("/book/{id}")
    public BookEntity findBookInfoById(@PathVariable("id") int id, HttpServletRequest request){
        //这个打印是验证gateway里配置到路由过滤器；
        System.out.println(request.getHeader("test"));
        return bookService.getBookInfoById(id);
    }

}
