package com.myd.dou.mutithread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName Player
 * @Description TODO
 * @Author 18050909
 * @Date 2020/5/26 9:17
 * @Version 1.0
 **/
public class Player implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public Player(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"准备好");
        try {
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+"开跑");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
