package com.myd.dou.redispack;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/9/28 14:14
 * @Description: TODO
 */
public class RedisLock3 {
    private static final String LOCK_SUCCESS = "OK";

        public static void main(String[]args){
            String requestId = "vaId";
            try {
               // String result = RedisUtil.jedis.set("key","vaId","NX","PX",100);
                String result = RedisUtil.jedis.setex("key",10,"NX");
                boolean flag = false;
                if (result.equals(LOCK_SUCCESS)) {

                    //异步
                    while("ok".equals("key值存在") && flag) {
                        //修改key的失效时间
                    }

                    //todo 处理业务
                    flag = true;
                }
            } finally {
                if (requestId.equals(RedisUtil.jedis.get("key"))) {
                    RedisUtil.jedis.del("key");
                }
            }
        }
}
