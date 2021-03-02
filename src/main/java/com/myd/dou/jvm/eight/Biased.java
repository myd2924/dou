package com.myd.dou.jvm.eight;

import java.util.List;
import java.util.Vector;

/**
 * @ClassName Biased
 * @Description 偏向锁
 * -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0 -client -Xmx512m -Xms512m
 * 255ms -XX:+UseBiasedLocking -XX:BiasedLockingStartupDelay=0
 * 2835ms
 * @Author 18050909
 * @Date 2020/5/23 15:51
 * @Version 1.0
 **/
public class Biased {
    public static List<Integer> numberList = new Vector<>();
    public static final int SIZE = 10000000;

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        int count = 0;
        int startnum = 0;
        while(count<SIZE){
            numberList.add(startnum);
            startnum += 2;
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
    }
}
