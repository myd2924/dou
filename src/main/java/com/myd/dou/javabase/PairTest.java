package com.myd.dou.javabase;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/12/27 19:39
 * @Description: TODO
 */
public class PairTest {
    public static void main(String[] args) {

        List<Pair<String,Long>> pairs = new ArrayList<>();
        Pair<String,Long> pair = new Pair("ha",1);
        Pair<String,Long> pair2 = new Pair("ha",1);
        pairs.add(pair);
        pairs.add(pair2);

        System.out.println(pair.getKey());
        AtomicInteger count = new AtomicInteger(0);
        for(int i=0;i<10;i++){

            System.out.println(count.getAndIncrement());
        }

        List 还好 = new ArrayList<>(null);
    }
}
