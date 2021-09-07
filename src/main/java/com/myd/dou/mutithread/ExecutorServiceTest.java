package com.myd.dou.mutithread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/9/3 16:16
 * @Description:
 */
public class ExecutorServiceTest {

    private static final Logger log = LoggerFactory.getLogger(ExecutorServiceTest.class);

    private static final long WAIT_TIME = 8*1000;
    private static final long AWAIT_TIME = 5*1000;

   /**public final static ExecutorService POOL1 = Executors.newFixedThreadPool(5);*/
   public final static ExecutorService POOL = new ThreadPoolExecutor(2, 5, 5L, TimeUnit.SECONDS, new ArrayBlockingQueue(1000), r -> new Thread(r, "my-pool-thread"), (r, executor) -> log.warn(r.toString() + " reject"));

    public static void main(String[] args) {
        /* 这是一个耗时任务 */
        Runnable task1 = () -> {
            try {
                log.info("task1 start");
                Thread.sleep(WAIT_TIME);
                log.info("task1 end");
            } catch (InterruptedException e) {
                log.error("task1 interrupted: " + e);
            }
        };

        Runnable task2 = () -> {
            try {
                log.info("task2 start");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error("task2 interrupted: " + e);
            }
        };

        POOL.execute(task1);
        for (int i=0;i<1000;i++){
            POOL.execute(task2);
        }

        try{
            POOL.shutdown();
            if(!POOL.awaitTermination(AWAIT_TIME, TimeUnit.MICROSECONDS)){
                POOL.shutdownNow();
            }
        } catch (InterruptedException ex){
            log.error("awaitTermination interrupted:"+ex);
            POOL.shutdownNow();
        }

        log.info("game over");
    }
}
