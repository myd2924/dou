package com.myd.dou.jdk8.lambda.supplier;

import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/28 10:24
 * @Description: TODO
 */
public class CacheUtil {
    private static HashMap<String, Object> localCache = new HashMap<>();

    public <T> T get(String key, RedisSupplier<T> redisSupplier) {
        Object value = localCache.get(key);
        if (Objects.isNull(value)) {
            T result = redisSupplier.get();
            this.set(key, result, redisSupplier.getExpire(), redisSupplier.getTimeUnit());
            return result;
        }
        return (T) value;
    }

    public void set(String key, Object value, int expire, TimeUnit timeUnit) {
        localCache.put(key, value);
    }
}
