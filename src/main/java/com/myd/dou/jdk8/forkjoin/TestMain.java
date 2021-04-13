package com.myd.dou.jdk8.forkjoin;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.LongStream;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/9 15:48
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(0, 10000000).toArray();
        Instant start = Instant.now();
        /*Forloop forloop = new Forloop();
        // 12ms
        long result = forloop.sumUp(numbers);*/
       /* ThreadPoolLoop threadPoolLoop = new ThreadPoolLoop();
        //23ms
        long result = threadPoolLoop.sumUp(numbers);*/
       /* ForkJoinPoolLoop forkJoinPool = new ForkJoinPoolLoop();
        //462ms
        long result = forkJoinPool.sumUp(numbers);*/
        Jdk8Parallel jdk8Parallel = new Jdk8Parallel();
        //71ms
        long result = jdk8Parallel.sumUp(numbers);
        Instant end = Instant.now();
        System.out.println("耗时："+ Duration.between(start,end).toMillis()+"ms");
        System.out.println("result="+result);
    }
}
