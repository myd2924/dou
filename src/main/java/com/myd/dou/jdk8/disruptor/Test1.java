package com.myd.dou.jdk8.disruptor;


import com.lmax.disruptor.RingBuffer;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/9 10:51
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {

        Queue<String> queue = new ArrayBlockingQueue<>(3);
        Queue<String> queue2 = new LinkedBlockingDeque<>(3);


        boolean add = queue.add("1");
        boolean offer = queue.offer("2");
        boolean offer2 = queue.offer("2");
        System.out.println(offer2);
        //queue full 抛异常 队列已满
        //boolean add2 = queue.add("1");
        //不抛异常
        boolean offer3 = queue.offer("2");
        System.out.println(offer3);
        System.out.println(queue);

        //取数据 不删数据
        String peek = queue.peek();
        System.out.println(peek);
        System.out.println(queue);

        //取数据 删数据
        final String poll = queue.poll();
        System.out.println(poll);
        System.out.println(queue);





    }
}
