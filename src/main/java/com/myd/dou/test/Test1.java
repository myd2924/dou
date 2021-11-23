package com.myd.dou.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/21 15:15
 * @Description: 写3个线程打印递增的数字, 线程1先打印1,2,3,4, 然后是线程2打印5,6,7,8,
 * 然后是线程3打印9,10,11,12. 接着再由线程1打印13,14,15,16....以此类推, 直到打印到40. 程序的输出结果应该为:
 */
public class Test1 {
    //打印数字
    private static volatile int k = 0;
    //计数器
    private static volatile int count1 = 0;
    //线程启停flag
    private static volatile int flag = 1;
    //上线
    final static int LIMIT = 40;

    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        final Condition condition1 = lock.newCondition();
        final Condition condition2 = lock.newCondition();
        final Condition condition3 = lock.newCondition();

        Thread thread1 = new Thread(() -> {
            while (k <= LIMIT) {
                lock.lock();
                try {
                    if(flag != 1){
                        condition1.await();
                    }
                    count1++;
                    k++;
                    System.out.println("thread1:" + k);
                    if (count1 % 4 == 0) {
                        count1 = 0;
                        flag = 2;
                        if(k!=LIMIT){
                            condition2.signal();
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }

        });

        Thread thread2 = new Thread(() -> {
            while (k < LIMIT) {
                lock.lock();
                try {
                    if(flag != 2){
                        condition2.await();
                    }
                    count1++;
                    System.out.println("thread2:" + k);
                    k++;
                    if (count1 % 4 == 0) {
                        count1 = 0;
                        flag = 3;
                        if(k!=LIMIT){
                            condition3.signal();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        });

        Thread thread3 = new Thread(() -> {
            while (k < LIMIT) {
                lock.lock();
                try {
                    if(flag != 3){
                        condition3.await();
                    }
                    count1++;
                    k++;
                    System.out.println("thread3:" + k);
                    if (count1 % 4 == 0) {
                        count1 = 0;
                        flag = 1;
                        if(k!=40){
                            condition1.signal();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        });
        thread1.start();
        Thread.sleep(2);
        thread2.start();
        Thread.sleep(2);
        thread3.start();

    }
}
