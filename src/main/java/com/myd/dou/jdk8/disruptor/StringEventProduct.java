package com.myd.dou.jdk8.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/6 15:24
 * @Description: 事件源  触发事件
 */
public class StringEventProduct {

    private final RingBuffer<StringEvent> ringBuffer;

    public StringEventProduct(RingBuffer<StringEvent> ringBuffer){
        this.ringBuffer = ringBuffer;
    }

    public void sendData(ByteBuffer byteBuffer){ //ringBuffer用来存储数据
        //通过索引获取空事件
        long sequence = ringBuffer.next();
        try{
            //切换成读模式
            StringEvent stringEvent = ringBuffer.get(sequence);
            //从byteBuffer读取传过来的值
            byteBuffer.flip();
            byte[] dst = new byte[byteBuffer.limit()];
            byteBuffer.get(dst,0,dst.length);
            //填充数据
            stringEvent.setValue(new String(dst));
            stringEvent.setId((int) sequence);
            //清缓存
            byteBuffer.clear();
        } finally { //确保事件发布  不会造成disruptor混乱
            ringBuffer.publish(sequence);
        }

    }
}
