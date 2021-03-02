package com.myd.dou.jdk8.interfac;

/**
 * @Classname SayHelloAImpl
 * @Description TODO
 * @Date 2020/7/23 11:10
 * @Created by mayd
 */
public class SayHelloAImpl implements SayHelloA1,SayHelloA2 {

    /**不知道选择哪个  只能显示的选择*/
    @Override
    public void myA() {
        System.out.println(" my A from me");
    }
}
