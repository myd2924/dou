package com.myd.dou.jdk8.forkjoin;

import java.util.Arrays;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/9 15:45
 * @Description: jdk8新特性  底层还是forkjoin框架
 */
public class Jdk8Parallel implements Calculator{
    @Override
    public long sumUp(long[] numbers) {
        return Arrays.stream(numbers).parallel().reduce(0,Long::sum);
    }
}
