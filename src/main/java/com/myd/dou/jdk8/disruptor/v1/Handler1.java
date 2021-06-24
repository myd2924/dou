package com.myd.dou.jdk8.disruptor.v1;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/23 15:58
 * @Description: 存数据库
 * EventHandler : 每个消费者对同一消息 独立消费
 * WorkHandler : 消费者不重复消费消息  例C1消费了消息m，C2不在消费消息m
 */
public class Handler1 implements EventHandler<TradeEvent>,WorkHandler<TradeEvent>{

    @Override
    public void onEvent(TradeEvent tradeEvent, long sequence, boolean endOfBatch) throws Exception {
        this.onEvent(tradeEvent);
    }

    @Override
    public void onEvent(TradeEvent tradeEvent) throws Exception {
        //获取当前订单号
        final String id = tradeEvent.getId();
        //获取当前线程id
        final long threadId = Thread.currentThread().getId();

        System.out.println(String.format("%s: thread id %s 订单%s保存到数据库",this.getClass().getSimpleName(),threadId,id));
    }
}
