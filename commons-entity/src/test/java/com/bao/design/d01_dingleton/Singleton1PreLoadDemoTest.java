package com.bao.design.d01_dingleton;


import com.bao.design.d01_singleton.Singleton1PreLoadDemo;
import org.junit.jupiter.api.Test;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/9 15:27
 */

public class Singleton1PreLoadDemoTest {

    @Test
    void test(){
        Singleton1PreLoadDemo instance1 = Singleton1PreLoadDemo.getInstance();
        Singleton1PreLoadDemo instance2 = Singleton1PreLoadDemo.getInstance();
        assert instance1 == instance2;
    }
}
