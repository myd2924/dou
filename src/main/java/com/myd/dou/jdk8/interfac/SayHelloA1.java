package com.myd.dou.jdk8.interfac;

/**
 * @Classname SayHelloA
 * @Description TODO
 * @Date 2020/7/23 11:07
 * @Created by mayd
 */
public interface SayHelloA1 extends SayHelloA{

    default void myA(){
        System.out.println("my A from A1");
    }

}
