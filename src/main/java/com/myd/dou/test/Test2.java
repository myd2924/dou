package com.myd.dou.test;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/21 15:16
 * @Description: 多线程执行功能时，A线程执行到某行代码后，如何实现：等待B线程执行结束后在继续执行
即：Java中如何让多线程按照自己指定的顺序执行？
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        System.out.println("主线程");
        threadA.start();
        threadA.join();
        System.out.println("等threadA线程结束，我才执行");
    }

    static class ThreadA extends Thread{
        @Override
        public void run(){
            System.out.println("子线程");
        }
    }
}
