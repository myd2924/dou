package com.myd.dou.jdk8.disruptor.v1;

import com.lmax.disruptor.EventHandler;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/25 09:55
 * @Description: TODO
 */
public class Handler5 implements EventHandler<TradeEvent> {
    @Override
    public void onEvent(TradeEvent tradeEvent, long l, boolean b) throws Exception {
        System.out.println("Handler5"+tradeEvent.getId());
    }
}
