package com.myd.dou.jdk8.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/6 15:17
 * @Description: 事件工厂
 */
public class StringEventFactory implements EventFactory <StringEvent>{
    @Override
    public StringEvent newInstance() {
        return new StringEvent();
    }
}
