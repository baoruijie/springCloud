package com.bao.design.d01_singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc
 * @author 骚包
 * @date 2023/1/9 15:01
 * @version 1.0
 */

public class SingletonLockDemo3 {
    private static SingletonLockDemo3 instance = null;
    private static SingletonLockDemo3 instance2 = null;
    private static volatile SingletonLockDemo3 instance3 = null;

    private SingletonLockDemo3(){}

    public static synchronized SingletonLockDemo3 getInstance(){
        if(instance == null){
            instance = new SingletonLockDemo3();
        }
        return instance;
    }
    // 2.把sychronized加在if(instance==null)判断语句里面，保证instance未实例化的时候才加锁
    public static synchronized SingletonLockDemo3 getInstance2() {
        if (instance2 == null) {
            synchronized (SingletonLockDemo3.class) {
                if (instance2 == null) {
                    instance2 = new SingletonLockDemo3();
                }
            }
        }
        return instance2;
    }

    // 3.new一个对象的代码是无法保证顺序性的，因此，我们需要使用另一个关键字volatile保证对象实例化过程的顺序性
    public static synchronized SingletonLockDemo3 getInstance3() {
        if (instance3 == null) {
            synchronized (instance3) {
                if (instance3 == null) {
                    instance3 = new SingletonLockDemo3();
                }
            }
        }
        return instance3;
    }
}
