package com.myd.dou.jdk8.interfac;

/**
 * @Classname SayHelloB
 * @Description TODO
 * @Date 2020/7/23 11:32
 * @Created by mayd
 */
public interface SayHelloB extends SayHelloA{

    default void sayHello(){
        System.out.println("hello from B");
    }
}
