package com.myd.dou.jdk8.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/9 15:21
 * @Description: ForkJoinPool
 */
public class ForkJoinPoolLoop implements Calculator{

    private ForkJoinPool pool;

    public ForkJoinPoolLoop() {
        this.pool = ForkJoinPool.commonPool();
    }

    private static class SumTask extends RecursiveTask<Long>{

        private long[] numbers;

        private int from;

        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }
        //此方法为ForkJoin的核心方法：对任务进行拆分  拆分的好坏决定了效率的高低
        @Override
        protected Long compute() {
            if(to-from < 6){
                long total = 0;
                for(int i=from;i<to;i++){
                    total += numbers[i];
                }
                return total;
            } else {// 否则，把任务一分为二，递归拆分(注意此处有递归)到底拆分成多少分 需要根据具体情况而定
                int middle = (from+to)/2;
                SumTask sumTaskLeft = new SumTask(numbers, from, middle);
                SumTask sumTaskRight = new SumTask(numbers, middle, to);
                sumTaskLeft.fork();
                sumTaskRight.fork();
                return sumTaskLeft.join() + sumTaskRight.join();
            }
        }
    }

    @Override
    public long sumUp(long[] numbers) {
        Long result = pool.invoke(new SumTask(numbers, 0, numbers.length - 1));
        return result;
    }
}
