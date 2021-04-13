package com.myd.dou.jdk8.completablefuture;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/9 10:23
 * @Description: 获取当前cpu数
 */
public class GetProcessors {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

    }
}
