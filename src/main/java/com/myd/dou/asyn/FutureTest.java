package com.myd.dou.asyn;

import java.util.concurrent.*;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/9/9 11:38
 * @Description: TODO
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        System.out.println("异步任务开始前");
        Future<Object> fu1 = executor.submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                Thread.sleep(2000);
                return "我是任务1.睡了二秒" ;
            }
        });
        System.out.println("异步任务1开始执行");
        Future<Object> fu2 = executor.submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                return "我是任务2.睡了一秒" ;
            }
        });
        Object o = fu1.get();
        Object o1 = fu2.get();
        System.out.println(o);
        System.out.println(o1);
    }
}
