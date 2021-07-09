package com.myd.dou.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/7/1 09:44
 * @Description: TODO
 */
public class BooleanTest {

    private static AtomicBoolean isWorking = new AtomicBoolean(false);

    public static void main(String[] args) {

        if(isWorking.compareAndSet(false,true)){
            System.out.println(isWorking);
        }
    }
}
