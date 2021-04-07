package com.myd.dou.jdk8.completablefuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/7 11:06
 * @Description: deadLock test
 */
public class CompletableFutureTest {

    public static final ExecutorService POOL = Executors.newFixedThreadPool(3, new ThreadFactory() {

        final AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("pool-thread["+ count.getAndIncrement() +"]");
            return thread;
        }
    });

    public static void main(String[] args) {

    }
}
