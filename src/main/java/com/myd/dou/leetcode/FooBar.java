package com.myd.dou.leetcode;

import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/5/29 15:05
 * @Description: TODO
 */
public class FooBar {
    private int n;
    CountDownLatch latch1 ;
    public FooBar(int n) {
        CountDownLatch latch1 = new CountDownLatch(n);
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < 2*n; i++) {
            if(latch1.getCount()%2 == 0){
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                latch1.countDown();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < 2*n; i++) {

            if(latch1.getCount()%2 == 1){
                printBar.run();
                latch1.countDown();
            }

        }
    }
}
