package com.myd.dou.jdk8.jdk8stream;

import java.util.UUID;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/10/23 16:27
 * @Description: TODO
 */
public class Test1 {
    public static void main(String[] args) {
        UUID.randomUUID().toString();
        System.out.println(UUID.randomUUID().toString().replace("-",""));
    }
}
