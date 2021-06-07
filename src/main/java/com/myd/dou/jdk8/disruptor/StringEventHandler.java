package com.myd.dou.jdk8.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/6 15:20
 * @Description: 处理器 也可以说是消费者
 */
public class StringEventHandler implements EventHandler<StringEvent>{
    @Override
    public void onEvent(StringEvent stringEvent, long l, boolean b) throws Exception {
        System.out.println("StringEventHandler(消费者)："+stringEvent+" sequence"+l+"boolean:"+b);
    }
}
