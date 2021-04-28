package com.myd.dou.jdk8.functionin;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/28 10:33
 * @Description:
 */
@FunctionalInterface
public interface InCalc<T> {
    T calc(int a,int b);
}
