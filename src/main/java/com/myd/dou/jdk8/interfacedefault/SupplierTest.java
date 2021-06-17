package com.myd.dou.jdk8.interfacedefault;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/17 11:25
 * @Description:
 */
public class SupplierTest {
    static Supplier<Integer> supplier = new Supplier<Integer>() {
        @Override
        public Integer get() {
            return new Random().ints(1,10).findAny().getAsInt();
        }
    };

    public static void main(String[] args) {
        System.out.println(supplier.get());
        System.out.println(test(supplier));
    }

    public static <T> T test(Supplier<T> supplier){
        final T t = supplier.get();
        return t;
    }
}
