package com.myd.dou.mutithread.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author <a href="mailto:mayd1234@163.com">MaYuanding</a>
 * @version 0.1.0
 * @Date:2022/3/22 09:59
 * @Description: 停车场景
 */
public class SemaphoreCar {

    /**
     * 停车场容量10
     */
    private static Semaphore semaphore = new Semaphore(10);
    /**
     * 模拟50辆车进入
     */
    private static int N = 50;

    public static void main(String[] args) {
        for (int i=0;i<N;i++){
            Thread thread = new Thread(()->{
                try {
                    System.out.println("====="+Thread.currentThread().getName()+"来到停车场");
                    if(semaphore.availablePermits() == 0){
                        System.out.println("车位不足，请耐心等待");
                    }
                    semaphore.acquire();
                    System.out.println("=>>>"+Thread.currentThread().getName()+"进入停车场");
                    Thread.sleep(new Random().nextInt(10000));//模拟停车时间
                    semaphore.release();
                    System.out.println("=<<<"+Thread.currentThread().getName()+"离开停车场");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },i+"号车");
            thread.start();
        }
    }
}
