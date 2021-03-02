package com.myd.dou.redispack;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/9/28 14:06
 * @Description: TODO
 */
public class RedisLock2{
    private static final String LOCK_SUCCESS = "OK";

    public static void main(String[] args) {
        String requestId = "vaId";
        try {
            //String result = RedisUtil.jedis.set("key","vaId","NX","PX",100);
            String result = RedisUtil.jedis.setex("key",10,"NX");
            if(result.equals(LOCK_SUCCESS)){
                //todo 业务

            }
        } finally {
            if(requestId.equals(RedisUtil.jedis.get("key"))){
                RedisUtil.jedis.del("key");
            }
        }
    }
}
