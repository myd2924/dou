package com.myd.dou.jdk8.response;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/11/30 10:34
 * @Description:
 */

public interface ResponseConverter<T,V> {
    V convert(T var1);
}
