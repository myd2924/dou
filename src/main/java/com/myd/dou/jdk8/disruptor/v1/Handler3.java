package com.myd.dou.jdk8.disruptor.v1;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/23 16:23
 * @Description:
 */
public class Handler3 implements EventHandler<TradeEvent>,WorkHandler<TradeEvent> {
    @Override
    public void onEvent(TradeEvent tradeEvent, long l, boolean b) throws Exception {
        this.onEvent(tradeEvent);
    }

    @Override
    public void onEvent(TradeEvent tradeEvent) throws Exception {
        // 获取当前线程id
        long threadId = Thread.currentThread().getId();
        // 获取订单号
        String id = tradeEvent.getId();
        System.out.println(String.format("%s：Thread Id %s 订单信息 %s 处理中 ....",
                this.getClass().getSimpleName(), threadId, id));
    }
}
