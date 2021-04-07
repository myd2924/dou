package com.myd.dou.jdk8.completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/7 11:06
 * @Description: deadLock test
 * https://www.cnblogs.com/lyuweigh/p/9568697.html
 * https://www.jianshu.com/p/6f3ee90ab7d3 还有很多其他特性
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<CompletableFuture<Void>> list = new ArrayList<>();

        for (int i=0;i<3;i++){
            CompletableFuture<Void> fu = CompletableFuture.runAsync(()->{
                try {
                    Thread.sleep(000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                CompletableFuture<Void> child = CompletableFuture.runAsync(()->{
                    System.out.println("我被执行了啊");
                },POOL);
                child.join();

            },POOL);

            System.out.println(String.format("第%s个父任务等待完成",i));

            list.add(fu);
        }
        System.out.println(list.get(0).get());
    }
}
