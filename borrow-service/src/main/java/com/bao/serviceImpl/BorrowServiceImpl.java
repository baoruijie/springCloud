package com.bao.serviceImpl;

import com.bao.entity.BookEntity;
import com.bao.entity.BorrowEntity;
import com.bao.entity.UserBorrowEntity;
import com.bao.entity.UserEntity;
import com.bao.mapper.BorrowMapper;
import com.bao.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BorrowServiceImpl implements BorrowService {

    @Resource
    BorrowMapper borrowMapper;

    @Resource
    RestTemplate template;

    @Override
    public UserBorrowEntity getUserBorrowInfoByUid(int uid) {
        List<BorrowEntity> borrow = borrowMapper.getBorrowByUid(uid);

//        服务调用方式一：通过ip:port调用
//        RestTemplate restTemplate = new RestTemplate();
//        UserEntity user = restTemplate.getForObject("http://localhost:8001/user/"+uid,UserEntity.class);
//        服务调用方式二：通过服务名调用。
        UserEntity user = template.getForObject("http://user-service/user/"+uid,UserEntity.class);
        System.out.println("user.toString()->"+user.toString());
//        获取每本书详细信息、方式一：通过ip:port调用
//        List<BookEntity> bookList = borrow.stream().map(b -> restTemplate.getForObject("http://localhost:8003/book/"+b.getBid(),BookEntity.class)).collect(Collectors.toList());
//        获取每本书详细信息、方式二：通过服务名调用。
        List<BookEntity> bookList = borrow.stream().map(b -> template.getForObject("http://book-service/book/"+b.getBid(),BookEntity.class)).collect(Collectors.toList());



        System.out.println(bookList);

        return new UserBorrowEntity(user,bookList);
    }
}
