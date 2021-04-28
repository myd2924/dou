package com.myd.dou.jdk8.functionin;

/**
 * @Classname Converter
 * @Description 函数式接口 只能有一个抽象方法
 * @Date 2020/7/23 13:57
 * @Created by mayd
 */
@FunctionalInterface
public interface Converter<T,R> {
    R conver (T from);

    default double sqrt(int a){
        return Math.sqrt(a);
    }

}
