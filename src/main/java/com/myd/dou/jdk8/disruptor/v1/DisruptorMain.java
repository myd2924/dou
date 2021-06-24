package com.myd.dou.jdk8.disruptor.v1;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;
import lombok.SneakyThrows;
import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/23 09:45
 * @Description: 放在一个函数里搞一波
 */

public class DisruptorMain {
    @SneakyThrows
    public static void main(String[] args) {

        StopWatch watch = new StopWatch(String.join("-","disruptorAll" ,"监控"));
        watch.start("init");

        final int bufferSize = 1024;
        ExecutorService executor = Executors.newFixedThreadPool(8);
        Disruptor<TradeEvent> disruptor = new Disruptor<TradeEvent>(new EventFactory<TradeEvent>() {
            @Override
            public TradeEvent newInstance() {
                return new TradeEvent();
            }
        },bufferSize,executor, ProducerType.SINGLE, new BusySpinWaitStrategy());
        //菱形操作
        //使用disruptor创建消费者组C1,C2
        EventHandlerGroup<TradeEvent> handlerGroup = disruptor.handleEventsWith(new Handler1(),new Handler2());
        //声明在C1,C2完事之后执行JMS消息发送操作 也就是流程走到C3
        handlerGroup.then(new Handler3());
        watch.stop();

        watch.start("execute");
        disruptor.start();
        CountDownLatch latch = new CountDownLatch(1);
        executor.submit(new ProductTrade(latch,disruptor));
        watch.stop();
        latch.await();
        disruptor.shutdown();
        executor.shutdown();
        System.out.println(watch.prettyPrint());

    }
}
