package com.myd.dou.jdk8.disruptor.v1;

import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/23 16:25
 * @Description: TODO
 */
public class ProductTrade implements Runnable {

    private CountDownLatch latch;
    Disruptor<TradeEvent> disruptor;

    private static final int LOOP = 20;

    public ProductTrade(CountDownLatch latch, Disruptor<TradeEvent> disruptor) {
        this.latch = latch;
        this.disruptor = disruptor;
    }

    @Override
    public void run() {
        TradeEventTranslator translator = new TradeEventTranslator();
        for (int i=0;i<LOOP;i++){
            disruptor.publishEvent(translator);
        }
        latch.countDown();
    }
}
