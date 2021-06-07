package com.myd.dou.jdk8.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/6 15:47
 * @Description: disruptor3推荐写法
 */
public class StringEventProductWithTranslator {
    private final RingBuffer<StringEvent> ringBuffer;

    public StringEventProductWithTranslator(RingBuffer<StringEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }
    //填充数据
    public static final EventTranslatorOneArg<StringEvent,ByteBuffer> TRANSLATOR = new EventTranslatorOneArg<StringEvent, ByteBuffer>() {
        @Override
        public void translateTo(StringEvent stringEvent, long sequence, ByteBuffer byteBuffer) {

            byteBuffer.flip();
            byte[] dst = new byte[byteBuffer.limit()];
            byteBuffer.get(dst, 0, dst.length);
            byteBuffer.clear();			// 为stringEvent赋值，填充数据
            stringEvent.setValue(new String(dst));
            stringEvent.setId((int) sequence);

        }
    };
    //发布事件
    public void sendData(ByteBuffer byteBuffer){
        ringBuffer.publishEvent(TRANSLATOR,byteBuffer);
    }
}
