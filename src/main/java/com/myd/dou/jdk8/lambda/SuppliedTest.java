package com.myd.dou.jdk8.lambda;

import java.util.function.Supplier;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/28 10:11
 * @Description:
 */
public class SuppliedTest {
    public static void main(String[] args) {
        String defaultVa  =  "maxixi";
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return defaultVa;
            }
        };
        System.out.println(supplier.get());
    }
}
