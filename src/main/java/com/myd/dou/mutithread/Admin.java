package com.myd.dou.mutithread;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author 18050909
 * @Date 2020/5/26 9:16
 * @Version 1.0
 **/
public class Admin implements Runnable{
    @Override
    public void run() {
        System.out.println("所有选手到齐");
    }
}
