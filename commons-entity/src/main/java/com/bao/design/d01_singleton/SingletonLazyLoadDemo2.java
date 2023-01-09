package com.bao.design.d01_singleton;

/**
 * @Desc 懒加载
 * @Author 骚包
 * @Date 2023/1/9 14:48
 * @Version 1.0
 */

public class SingletonLazyLoadDemo2 {
    private static SingletonLazyLoadDemo2 instance = null;

    private SingletonLazyLoadDemo2(){}

    public static SingletonLazyLoadDemo2 getInstance(){
        if(instance == null){
            instance = new SingletonLazyLoadDemo2();
        }
        return instance;
    }

}
