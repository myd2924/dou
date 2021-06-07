package com.myd.dou.jdk8.disruptor;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/6 15:15
 * @Description: 定义一个事件 用来接受数据的javabean对象
 */
@Getter
@Setter
@ToString
public class StringEvent {

    private Integer id;
    private String value;

}
