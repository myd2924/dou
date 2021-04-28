package com.myd.dou.jdk8.lambda.supplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/28 10:22
 * @Description:
 */
@Getter
@Setter
@AllArgsConstructor
public class RedisSupplier<T> {

    private int expire;

    private TimeUnit timeUnit;

    Supplier<T> supplier;

    public T get(){
        return this.supplier.get();
    }


}
