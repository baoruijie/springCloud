package com.bao.design.d01_dingleton;

import com.bao.design.d01_singleton.Singleton1PreLoadDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author 骚包
 * @version 1.0
 * @desc
 * @date 2023/1/9 15:44
 */

public class Test implements Runnable{

    static CountDownLatch latch = new CountDownLatch(100);
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Test());
            t.start();
        }
        Thread t1 = new Thread(new Test());
        Thread t2 = new Thread(new Test());

        t1.start();
        t2.start();

        for (int i = 0; i < 100; i++) {
            Thread th = new Thread(Singleton1PreLoadDemo::getInstance);
            th.start();
            latch.countDown();
        }
    }

    @Override
    public void run() {
        Singleton1PreLoadDemo instance = Singleton1PreLoadDemo.getInstance();
        System.out.println(instance);
    }
}
