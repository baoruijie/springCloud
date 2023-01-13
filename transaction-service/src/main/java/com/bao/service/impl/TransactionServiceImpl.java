package com.bao.service.impl;

import com.bao.mapper.TransactionDao;
import com.bao.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/13 15:57
 */

@Service
public class TransactionServiceImpl implements TransactionService {

    @Resource
    private TransactionDao dao;

    @Override
    public int update1() {
        return dao.update(1);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int update2() {
        dao.insert("", "", "", "", new Date());
        return dao.update(2);
    }

    @Override
    public int update3() {
        return 0;
    }

    @Override
    public int update4() {
        return 0;
    }

    @Override
    public int update5() {
        return 0;
    }

    @Override
    public int update6() {
        return 0;
    }

    @Override
    public int update7() {
        return 0;
    }
}
