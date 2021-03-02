package com.myd.dou.redispack;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

/**
 * @ClassName RedisUtil
 * @Description
 * @Author 18050909
 * @Date 2020/5/14 11:39
 * @Version 1.0
 **/
public class RedisUtil {
    static Jedis jedis = null;

    public static Jedis getInstance() {
        if(null == jedis){
            jedis = cli_single("127.0.0.1", 6379);
        }
        return jedis;
    }

    public static Jedis cli_single(String host, int port) {
        try {
            return new Jedis(host, port);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Jedis instance = RedisUtil.getInstance();
        instance.set("my","mayuadnig");
        System.out.println(instance.get("my"));
    }

}
