package com.myd.dou.aba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AtoMicAbaTest
 * @Description 复现cas场景下的aba问题
 * @Author 18050909
 * @Date 2020/5/18 17:56
 * @Version 1.0
 **/
public class AtoMicAbaTest {
    private static AtomicInteger index = new AtomicInteger(10);
    public static void main(String[] args) {
        new Thread(()->{
            index.compareAndSet(10,11);
            index.compareAndSet(11,10);
            System.out.println(Thread.currentThread().getName()+": 10-11-10");
        },"大曦").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                boolean isSuccess = index.compareAndSet(10, 12);
                System.out.println(Thread.currentThread().getName()+":index的预期值是10 "+isSuccess+" 设置的值："+index.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"二曦").start();
    }
}
