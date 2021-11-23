package com.myd.dou.test;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/21 17:02
 * @Description:
 */
public class Test3 {

    private static volatile Integer kk = 0;

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();

    }

    static class Thread1 implements Runnable{
        private Integer k;

        public void setK(Integer k) {
            this.k = k;
        }

        @Override
        public void run() {

        }
    }

    static class Thread2 implements Runnable{

        @Override
        public void run() {

        }
    }

    static class Thread3 implements Runnable{

        @Override
        public void run() {

        }
    }

}
