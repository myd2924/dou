package com.myd.dou.jdk8.lambda.supplier;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/28 10:26
 * @Description: TODO
 */
public class TestMain {
    public static void main(String[] args) {
        RedisSupplier<String> redisSupplier = new RedisSupplier<>(1, TimeUnit.DAYS, () -> "valueB");
        CacheUtil cacheUtil = new CacheUtil();
        String result = cacheUtil.get("B", redisSupplier );
        System.out.println(result);
    }
}
