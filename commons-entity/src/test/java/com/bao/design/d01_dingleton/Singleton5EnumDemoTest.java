package com.bao.design.d01_dingleton;

import com.bao.design.d01_singleton.Singleton5EnumDemo;
import org.junit.jupiter.api.Test;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/10 15:24
 */

public class Singleton5EnumDemoTest {

    @Test
    void test(){
        Singleton5EnumDemo instance1 = Singleton5EnumDemo.getInstance();
        Singleton5EnumDemo instance2 = Singleton5EnumDemo.getInstance();
        assert instance1 == instance2;
    }
}
