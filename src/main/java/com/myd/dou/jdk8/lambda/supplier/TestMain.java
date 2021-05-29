package com.myd.dou.jdk8.lambda.supplier;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/28 10:26
 * @Description:
 */
public class TestMain {
    public static void main(String[] args) {
        RedisSupplier<String> redisSupplier = new RedisSupplier<>(1, TimeUnit.DAYS, () -> "valueB");
        CacheUtil cacheUtil = new CacheUtil();
        String result = cacheUtil.get("B", redisSupplier );
        System.out.println(result);

        String str = "ndjksnkdk";
        System.out.println(str.indexOf('n', 2));
        String join = StringUtils.join(str);
        System.out.println(join);




    }

    public static int query(String s){
        int i = 0;
        int flag = 0;
        int length = 0;
        int result = 0;
        while (i < s.length()) {
            int pos = s.indexOf(s.charAt(i),flag);
            if (pos < i) {
                if (length > result) {
                    result = length;
                }
                if (result >= s.length() - pos - 1) {
                    return result;
                }
                length = i - pos - 1;
                flag = pos + 1;
            }
            length++;
            i++;
        }
        return length;
    }

}
