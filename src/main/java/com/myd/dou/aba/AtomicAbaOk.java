package com.myd.dou.aba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ClassName AtomicAbaOk
 * @Description TODO
 * @Author 18050909
 * @Date 2020/5/18 19:28
 * @Version 1.0
 **/
public class AtomicAbaOk {
    private static AtomicStampedReference<Integer> stamped = new AtomicStampedReference(10,1);
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" 版本号："+stamped.getStamp()+ " 预期值： "+stamped.getReference());
            stamped.compareAndSet(10,11,1,2);
            System.out.println(Thread.currentThread().getName()+" 版本号："+stamped.getStamp()+ " 修改值： "+stamped.getReference());
            stamped.compareAndSet(11,10,2,3);
            System.out.println(Thread.currentThread().getName()+" 版本号："+stamped.getStamp()+ " 修改值： "+stamped.getReference());
        },"大曦").start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(Thread.currentThread().getName()+" 版本号："+stamped.getStamp()+ " 预期值： "+stamped.getReference());
                boolean b = stamped.compareAndSet(10, 12, 1, 2);
                System.out.println(Thread.currentThread().getName()+" 版本号："+stamped.getStamp()+ " 预期值： "+stamped.getReference()+" 修改成功了吗="+b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"二曦").start();
    }
}
