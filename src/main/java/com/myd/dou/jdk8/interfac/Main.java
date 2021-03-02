package com.myd.dou.jdk8.interfac;

/**
 * @Classname Main
 * @Description 测试
 * @Date 2020/7/23 10:58
 * @Created by mayd
 */
public class Main {
    public static void main(String[] args) {
        FormuaImpl formua = new FormuaImpl();
        /**default 方式*/
        System.out.println(formua.sqrt(16));
        System.out.println(formua.calculate(16));
        /**static 方式*/
        System.out.println(Formua.pow(16,2));

        /**菱形问题 显示确定*/
        SayHelloAImpl sayHelloA = new SayHelloAImpl();
        sayHelloA.myA();

        /**就近 就具体原则*/
        new SayHelloImpl().sayHello();
    }
}
