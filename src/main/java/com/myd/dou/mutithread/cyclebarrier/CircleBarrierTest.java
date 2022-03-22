package com.myd.dou.mutithread.cyclebarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicBarrierTest
 * @Description 回环栅栏测试
 * @Author 18050909
 * @Date 2020/5/26 9:02
 * @Version 1.0
 **/
public class CircleBarrierTest {

    private static CyclicBarrier BARRIER = new CyclicBarrier(4);
    public static void main(String[] args) {
        for (int i=0;i<4;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"玩家准备");
                    try {
                        Thread.sleep(5000);
                        BARRIER.await();
                        System.out.println(Thread.currentThread().getName()+"玩家入场");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        System.out.println("wohahahah,我不会等的");
    }
}
