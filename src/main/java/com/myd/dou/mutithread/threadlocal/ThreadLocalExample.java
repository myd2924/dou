package com.myd.dou.mutithread.threadlocal;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/7/22 15:41
 * @Description: TODO
 */
public class ThreadLocalExample {
    public static void main(String[] args) {
        MyRunnable myShareRunnable = new MyRunnable();
        Thread th1 = new Thread(myShareRunnable);
        Thread th2 = new Thread(myShareRunnable);
        th1.start();
        th2.start();
    }

    public static class MyRunnable implements Runnable{

        private ThreadLocal threadLocal = new ThreadLocal();

        @Override
        public void run() {
            threadLocal.set((int)(Math.random()*100D));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e){
            }

            System.out.println(threadLocal.get());
        }
    }

}
