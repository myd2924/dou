package com.myd.dou.single;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/16 19:57
 * @Description: 懒汉 多线程
 */
public class LazyTestMore {

    private volatile static LazyTestMore instance = null;

    private LazyTestMore(){}

    public static LazyTestMore getInstance(){
        if(null == instance){
            synchronized (LazyTestMore.class){
                if(null == instance){
                    instance = new LazyTestMore();
                }
            }
        }
        return instance;
    }

}
