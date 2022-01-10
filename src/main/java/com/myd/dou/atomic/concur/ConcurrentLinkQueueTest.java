package com.myd.dou.atomic.concur;

import org.springframework.util.StopWatch;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/12/14 17:58
 * @Description: ConcurrentLinkQueue测试
 * linkedQueue.isEmpty()
 * linkedQueue.size() 会遍历 坑
 */
public class ConcurrentLinkQueueTest {

    private static ConcurrentLinkedQueue<Integer> linkedQueue = new ConcurrentLinkedQueue<Integer>();
    private static int count = 100000;
    private static int count2 = 2;
    private static CountDownLatch countDownLatch = new CountDownLatch(count2);

    public static void init(){
        for (int i=0;i<count;i++){
            linkedQueue.offer(i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        StopWatch stopWatch = new StopWatch("my1");
        stopWatch.start("初始化计时");
        init();
        stopWatch.stop();
        stopWatch.start("消费数据计时");
        for (int i=0;i<count2;i++){
            executorService.execute(new Poll());
        }
        countDownLatch.await();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        executorService.shutdown();
    }

    static class Poll implements Runnable{

        @Override
        public void run() {
            //71ms
            while(!linkedQueue.isEmpty()){
            //7170ms
            //while(linkedQueue.size()>0){
                linkedQueue.poll();
            }
            countDownLatch.countDown();
        }
    }
}
