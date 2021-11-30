package com.myd.dou.util;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/24 14:53
 * @Description:
 */
@FunctionalInterface
public interface BeanCopierCallBack<S,T> {
    void callback(S s,T t);
}
