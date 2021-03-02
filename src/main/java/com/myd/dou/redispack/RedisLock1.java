package com.myd.dou.redispack;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/9/28 14:01
 * @Description: TODO
 */
public class RedisLock1 {
    public static void main(String[] args) {
        try{
            Long setnx = RedisUtil.jedis.setnx("key", "va");
            //todo 业务

        } finally {
            RedisUtil.jedis.del("key");
        }
    }
}
