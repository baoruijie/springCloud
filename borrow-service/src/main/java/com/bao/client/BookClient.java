package com.bao.client;

import com.bao.entity.BookEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("book-service")
public interface BookClient {


    @RequestMapping("/book/{id}")
    BookEntity findBookInfoById(@PathVariable("id") int id);
}
