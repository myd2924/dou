package com.myd.dou.mutithread.cyclebarrier;

import com.myd.dou.mutithread.Admin;
import com.myd.dou.mutithread.Player;

import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName CyclicTest2
 * @Description TODO
 * @Author 18050909
 * @Date 2020/5/26 9:20
 * @Version 1.0
 **/
public class CyclicTest2 {
    public static void main(String[] args) {
        int playerCount = 10;
        Admin admin = new Admin();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(playerCount,admin);
        for (int i=0;i<10;i++){
            Player player = new Player(cyclicBarrier);
            new Thread(player).start();
        }
    }
}
