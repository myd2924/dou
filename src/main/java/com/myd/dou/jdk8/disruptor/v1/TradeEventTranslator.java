package com.myd.dou.jdk8.disruptor.v1;

import com.lmax.disruptor.EventTranslator;

import java.util.UUID;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/23 16:32
 * @Description: 事件对象转换器
 */
public class TradeEventTranslator implements EventTranslator<TradeEvent> {
    @Override
    public void translateTo(TradeEvent tradeEvent, long sequence) {
        tradeEvent.setId(UUID.randomUUID().toString());
    }
}
