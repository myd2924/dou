package com.myd.dou.jdk8.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/9 14:49
 * @Description: 传统线程池多线程计算
 */
public class ThreadPoolLoop implements Calculator {
    /**
     * 核数
     */
    private int parallism;
    /**
     * 线程池
     */
    private ExecutorService pool;

    public ThreadPoolLoop() {
        this.parallism = Runtime.getRuntime().availableProcessors();
        this.pool = Executors.newFixedThreadPool(parallism);
    }

    private static class SumTask implements Callable<Long>{

        private long[] numbers;

        private int from;

        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long total = 0;
            for(int i=from;i<=to;i++){
                total += numbers[i];
            }
            return total;
        }
    }

    @Override
    public long sumUp(long[] numbers) {
        List<Future<Long>> results = new ArrayList<>();
        int part = numbers.length/parallism;

        for(int i=0;i<parallism;i++){
            //开始位置
            int from = i*part;
            int to = (i == parallism-1) ? numbers.length-1 : (i+1)*part-1;
            results.add(pool.submit(new SumTask(numbers,from,to)));
        }

        long total = 0;
        for(Future<Long> future :results ){
            try {
                total += future.get();
            } catch (InterruptedException e) {
            } catch (ExecutionException e) {
            }
        }

        return total;
    }
}
