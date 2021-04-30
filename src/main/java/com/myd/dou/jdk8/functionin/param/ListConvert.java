package com.myd.dou.jdk8.functionin.param;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/30 09:42
 * @Description:
 */
@FunctionalInterface
public interface ListConvert<T,K,R> {
    R convert(T t,K k,R r);
}
