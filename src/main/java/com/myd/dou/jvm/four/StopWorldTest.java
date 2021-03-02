package com.myd.dou.jvm.four;

import java.util.HashMap;

/**
 * @ClassName StopWorldTest
 * @Description -Xmx1g -Xms1g -Xmn512k -XX:+UseSerialGC -XX:+PrintGCDetails
 * @Author 18050909
 * @Date 2020/5/22 11:00
 * @Version 1.0
 **/
public class StopWorldTest {
    public static class MyThread extends Thread{
        HashMap map = new HashMap();

        @Override
        public void run() {
            try{
                while(true){
                    if(map.size()*512/1024/1024>900){
                        map.clear();
                        System.out.println("clean map");
                    }

                    byte[] b;
                    for (int i=0;i<100;i++){
                        b= new byte[512];
                        map.put(System.nanoTime(),b);
                    }
                    Thread.sleep(1);
                }
            }catch (Exception e){

            }
        }
    }

    public static class PrintThread extends Thread{
        public static final long startTime = System.currentTimeMillis();

        @Override
        public void run() {
            try{
                while (true){
                    long t = System.currentTimeMillis()-startTime;
                    System.out.println(t/1000+"."+t%1000);
                    Thread.sleep(100);
                }
            } catch (Exception e){

            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        PrintThread printThread = new PrintThread();
        myThread.start();
        printThread.start();
    }
}
