package com.myd.dou.mutithread;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName MyThreadLocalStringDemo2
 * @Description TODO
 * @Author 18050909
 * @Date 2020/6/5 11:21
 * @Version 1.0
 **/
public class MyThreadLocalStringDemo2 {

    private static ThreadLocal<String> local = new ThreadLocal();

    public String getString(){
        return local.get();
    }

    public void setString(String str){
        local.set(str);
    }

    public static void main(String[] args) {
        int threads = 20;
        MyThreadLocalStringDemo2 demo = new MyThreadLocalStringDemo2();
        CountDownLatch countDownLatch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(() -> {
                demo.setString(Thread.currentThread().getName());
                System.out.println(demo.getString());
                countDownLatch.countDown();
            }, "thread - " + i);
            thread.start();
        }
    }

}
