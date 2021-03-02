package com.myd.dou.jvm.eight;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @ClassName Atomic
 * @Description 宠儿 LongAdder
 * @Author 18050909
 * @Date 2020/5/23 16:29
 * @Version 1.0
 **/
public class Atomic {
    /**最大线程数*/
    private static final int MAX_THREADS = 3;
    /**最大任务数*/
    private static final int TASK_COUNT = 3;
    /**目标数*/
    private static final int TARGET_COUNT = 10000000;

    /**无锁的院子==原子操作*/
    private AtomicLong acount = new AtomicLong(0L);
    private LongAdder lacount = new LongAdder();
    private long count  = 0;

    static CountDownLatch cdlAtmic = new CountDownLatch(TASK_COUNT);
    static CountDownLatch cdlSynch = new CountDownLatch(TASK_COUNT);
    static CountDownLatch cdlLondAdder = new CountDownLatch(TASK_COUNT);

    /**有锁加法*/
    protected synchronized long inc(){
        return ++count;
    }

    /**有锁操作*/
    protected synchronized long getCount(){
        return count;
    }

    public void clearCount(){
        count = 0;
    }

    public class SyncThread implements Runnable{

        protected String name;
        protected long startTime;
        Atomic out;

        public SyncThread(Atomic o,long startTime){
            out = o;
            this.startTime = startTime;
        }

        @Override
        public void run() {
            long v = out.getCount();
            while(v<TARGET_COUNT){
                v = out.inc();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("syn cost time:"+(endTime - startTime));
            cdlSynch.countDown();
        }
    }

    public void testSync() throws InterruptedException {
        ExecutorService exe = newFixedThreadPool(MAX_THREADS);
        long startTime = System.currentTimeMillis();
        SyncThread sync = new SyncThread(this,startTime);
        for (int i=0;i<TASK_COUNT;i++){
            exe.submit(sync);
        }
        cdlSynch.await();
        exe.shutdown();
    }

    public class AtomicThread implements Runnable{

        protected String name;
        protected long startTime;

        public AtomicThread(long startTime) {
            this.startTime = startTime;
        }

        @Override
        public void run() {
            long v = acount.get();
            while(v<TARGET_COUNT){
                v = acount.incrementAndGet();
            }
            long end = System.currentTimeMillis();
            System.out.println("Atomic cost time :"+(end-startTime));
            cdlAtmic.countDown();
        }

    }

    public void testAtomic(){
        ExecutorService exe = newFixedThreadPool(MAX_THREADS);
        long start = System.currentTimeMillis();
        AtomicThread atomicThread = new AtomicThread(start);
        for (int i=0;i<TASK_COUNT;i++){
            exe.submit(atomicThread);
        }
        cdlAtmic.countDown();
        exe.shutdown();
    }

    public class LongAdderThread implements Runnable{

        protected long start;

        public LongAdderThread(long start) {
            this.start = start;
        }

        @Override
        public void run() {
            long v = lacount.sum();
            while(v<TARGET_COUNT){
                lacount.increment();
                v = lacount.sum();
            }
            long end = System.currentTimeMillis();
            System.out.println("longAdder cost time:"+(end-start));
            cdlLondAdder.countDown();
        }
    }

    public void testLongAdder() throws InterruptedException {
        ExecutorService exe = newFixedThreadPool(MAX_THREADS);
        long start = System.currentTimeMillis();
        LongAdderThread longAdderThread = new LongAdderThread(start);
        for (int i=0;i<TASK_COUNT;i++){
            exe.submit(longAdderThread);
        }
        cdlLondAdder.await();
        exe.shutdown();
    }


    public static void main(String[] args) throws InterruptedException {
        Atomic at = new Atomic();
        at.testAtomic();
        at.testSync();
        at.testLongAdder();
    }
}
