package com.myd.dou.jdk8.forkjoin;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/9 13:49
 * @Description: 计算1至10000000的和
 */
public interface Calculator {

    /**
     * 数组求和
     * @param numbers
     * @return
     */
    long sumUp(long[] numbers);
}
