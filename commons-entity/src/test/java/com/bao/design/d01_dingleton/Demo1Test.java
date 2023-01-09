package com.bao.design.d01_dingleton;


import com.bao.design.d01_singleton.SingletonPreLoadDemo1;
import org.junit.jupiter.api.Test;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/9 15:27
 */

public class Demo1Test {

    @Test
    void test(){
        SingletonPreLoadDemo1 instance1 = SingletonPreLoadDemo1.getInstance();
        SingletonPreLoadDemo1 instance2 = SingletonPreLoadDemo1.getInstance();
        assert instance1 == instance2;
    }
}
