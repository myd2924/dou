package com.myd.dou.aba;

import java.util.concurrent.atomic.LongAdder;


/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/3/4 16:51
 * @Description:
 */
public class LongAdderTest {

    private final LongAdder count = new LongAdder();
    public static void main(String[] args) {
        print();
    }

    public static void print() {
        LongAdderTest longAdderTest = new LongAdderTest();
        for (int i=0;i<5;i++){
            longAdderTest.count.increment();
            System.out.println(longAdderTest.count.intValue());
        }
    }
}
