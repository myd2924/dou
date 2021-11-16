package com.myd.dou.single;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/16 19:56
 * @Description: 懒汉1  适合单线程
 */
public class LazyTest1 {

    private static LazyTest1 instance = null;

    private LazyTest1(){}

    public static LazyTest1 getInstance(){
        if(instance == null){
            instance = new LazyTest1();
        }
        return instance;
    }

}
