package com.myd.dou.jdk8.disruptor.v1;


import com.lmax.disruptor.EventHandler;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/23 16:09
 * @Description: 订单信息发送至其他系统
 */
public class Handler2 implements EventHandler<TradeEvent> {

    @Override
    public void onEvent(TradeEvent tradeEvent, long sequence, boolean endOfBatch) throws Exception {
        final long threadId = Thread.currentThread().getId();
        String id = tradeEvent.getId();
        System.out.println(String.format("%s: thread id %s 订单%s发送至kafka系统",this.getClass().getSimpleName(),threadId,id));
    }
}
