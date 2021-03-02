package com.myd.dou.mutithread;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName MyThreadLocalStringDemo
 * @Description TODO
 * @Author 18050909
 * @Date 2020/6/5 11:14
 * @Version 1.0
 **/
public class MyThreadLocalStringDemo {

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public static void main(String[] args) {
        int threads = 25;
        MyThreadLocalStringDemo demo = new MyThreadLocalStringDemo();
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for(int i=0;i<threads;i++){
            Thread thread = new Thread(()->{
                demo.setStr(Thread.currentThread().getName());
                System.out.println(demo.getStr());
                countDownLatch.countDown();
            },"thread"+i);
            thread.start();
        }

    }
}
