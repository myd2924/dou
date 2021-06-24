package com.myd.dou.jdk8.disruptor.v1;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/23 15:55
 * @Description: 事件对象
 */
@Setter
@Getter
public class TradeEvent implements Serializable{

    private static final long serialVersionUID = -4708842802680762399L;
    /**
     * 订单号
     */
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 价格
     */
    private double price;

    private AtomicInteger count = new AtomicInteger(0);
}
