/**
 * @Date:2021/6/6 15:14
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @Description:
第一：建立一个Event类

第二：建立一个工厂Event类，用于创建Event类实例对象

第三：需要有一个监听事件类，用于处理数据（Event类）

第四：我们需要进行测试代码编写。实例化Disruptor实例，配置参数。然后我们对Disruptor实例绑定监听事件类，接受并处理数据。

第五：在Disruptor中，真正存储数据的核心叫做RingBuffer，我们通过Disruptor实例拿到它，然后把数据生产出来，把数据加入到RingBuffer的实例对象中即可

作者：刘信坚
链接：https://www.imooc.com/article/68795
 * @version 0.1.0
 */
package com.myd.dou.jdk8.disruptor;