package com.myd.dou.jdk8.interfac;

/**
 * @Classname Formua
 * @Description 接口的默认方法
 * @Date 2020/7/23 10:35
 * @Created by mayd
 */
public interface Formua {
    /**计算*/
    double calculate(int a);

    /**开平方 接口的默认方法--java8特性一*/
    default double sqrt(int a){
        return Math.sqrt(a);
    }
    /**次方 a的b次方 接口的默认方法--java8特性一*/
    static double pow(int a,int b){
        return Math.pow(a,b);
    }

}
