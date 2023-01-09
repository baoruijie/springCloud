package com.bao.design.d01_singleton;

/**
 * @Desc 预加载
 * @Auth 骚包
 * @Date 2023/1/9 14:48
 * @Version 1.0
 */
public class SingletonPreLoadDemo1 {
    private static SingletonPreLoadDemo1 instance = new SingletonPreLoadDemo1();

    private SingletonPreLoadDemo1(){}

    public static SingletonPreLoadDemo1 getInstance(){
        return instance;
    }
}
