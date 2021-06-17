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
        List<CompletableFuture<String>> list = new ArrayList<>();

        for (int i=0;i<3;i++){
            //CompletableFuture.runAsync() 返回空
            CompletableFuture<String> fu = CompletableFuture.supplyAsync(()->{
                try {
                    Thread.sleep(000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                CompletableFuture<String> child = CompletableFuture.supplyAsync(()->{
                    System.out.println("我被执行了啊");
                    String a = "hh";
                    return a;
                },POOL);
                child.join();
                return "hebi";
            }

            ,POOL);

            System.out.println(String.format("第%s个父任务等待完成",i));

            list.add(fu);
        }
        System.out.println(list.get(0).get()+"  "+list.get(1).get());
    }
}
