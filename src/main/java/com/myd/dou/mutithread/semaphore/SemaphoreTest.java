package com.myd.dou.mutithread.semaphore;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2022/3/21 11:04
 * @Description:
 * Semaphore 信号量 控制同时访问线程的个数，通过acquire获取许可，通过release释放
 * CyclicBarrier 回环栅栏 一组线程一起等待到某个点，再全部同时执行下一个任务
 * CountDownLatch 线程计数器 某个线程等待其他线程执行完，执行下一个任务。
 *
 * 场景：八个人只有5个机器同时可使用
 */
@Slf4j
public class SemaphoreTest {

    @Test
    public void test(){
        int N = 8 ;
        Semaphore semaphore = new Semaphore(5);
        for(int i=0;i<N;i++){
            new Worker(i,semaphore).start();
        }
    }

    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run(){
            try{
                semaphore.acquire();
                log.info("work"+this.num+" 占用一个机器 ");

                Thread.sleep(200);
                log.info("work"+this.num+" 释放一个机器");
                semaphore.release();
            } catch (InterruptedException e){
                log.info(e.getMessage());
            }
        }
    }
}
