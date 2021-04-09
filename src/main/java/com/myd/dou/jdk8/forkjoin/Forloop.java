package com.myd.dou.jdk8.forkjoin;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/9 14:45
 * @Description: 最low的loop循环
 */
public class Forloop implements Calculator {
    @Override
    public long sumUp(long[] numbers) {
        long result = 0;
        for (long i : numbers){
            result += i;
        }
        return result;
    }
}
