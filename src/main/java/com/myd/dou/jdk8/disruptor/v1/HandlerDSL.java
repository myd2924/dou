package com.myd.dou.jdk8.disruptor.v1;

import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/25 09:33
 * @Description:
 */
public class HandlerDSL {
    /**
     * 多个消费者不重复消费
     * @param disruptor
     */
    public static void processDslOne(Disruptor<TradeEvent> disruptor){
        //使用disruptor创建消费者组C1,C2
        final EventHandlerGroup<TradeEvent> handlerGroup = disruptor.handleEventsWith(new Handler1(), new Handler2());
        //多个消费者不重复消费
        Handler3[] customers = new Handler3[]{new Handler3(),new Handler3(),new Handler3()};
        handlerGroup.thenHandleEventsWithWorkerPool(customers);
    }

    /**
     * 消费者四边形模式
     * @param disruptor
     */
    public static void processDslTwo(Disruptor<TradeEvent> disruptor){
        //使用disruptor创建消费者组C1,C2
        EventHandlerGroup<TradeEvent> handlerGroup = disruptor.handleEventsWith(new Handler1(),new Handler2());
        //声明在C1,C2完事之后执行JMS消息发送操作 也就是流程走到C3
        handlerGroup.then(new Handler3());
    }

    /**
     * 消费者顺序消费
     * @param disruptor
     */
    public static void processDslThree(Disruptor<TradeEvent> disruptor){
        disruptor.handleEventsWith(new Handler1())
                .handleEventsWith(new Handler2())
                .handleEventsWith(new Handler3());
    }

    /**
     * 消费者六边形模式
     * @param disruptor
     */
    public static void processDslFour(Disruptor<TradeEvent> disruptor){
        Handler1 h1 = new Handler1();
        Handler2 h2 = new Handler2();
        Handler3 h3 = new Handler3();
        Handler4 h4 = new Handler4();
        Handler5 h5 = new Handler5();
        disruptor.handleEventsWith(h1, h2);
        disruptor.after(h1).handleEventsWith(h4);
        disruptor.after(h2).handleEventsWith(h5);
        disruptor.after(h4, h5).handleEventsWith(h3);
    }

}
