package com.myd.dou.mutithread.threadlocal;

import com.myd.dou.dto.User;

/**
 * @ClassName TjhreadLocalTest
 * @Description TODO
 * @Author 18050909
 * @Date 2020/6/5 10:46
 * @Version 1.0
 **/
public class TjhreadLocalTest {

    private User user;

    public void setUser() {
        user = new User();
    }

    public User getUser(){
        return user;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                TjhreadLocalTest localTest = new TjhreadLocalTest();
                localTest.setUser();
                System.out.println(localTest.getUser().hashCode());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                TjhreadLocalTest localTest = new TjhreadLocalTest();
                localTest.setUser();
                System.out.println(localTest.getUser().hashCode());
            }
        }).start();
    }

}
