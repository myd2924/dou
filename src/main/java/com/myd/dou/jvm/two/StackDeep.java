package com.myd.dou.jvm.two;

/**
 * @ClassName StackDeep
 * @Description -Xss 设置线程栈的大小
 * -Xss256k    deepCount=2469
 * -Xss1m 默认 deepCount=24710  reserve();
 *            deepCount=16824   reserve(0,1,2);
 *
 * 每个线程分配一个栈，每一个方法调用就是往栈里push栈贞，方法执行结束，pop栈贞
 * 栈贞包含三个部分
 * 【局部变量表[存放方法内的局部变量和方法参数]，
 * 操作数栈[保存局部变量的计算结果及临时存储空间]，
 * 贞数据区[保存常量池的指针]】
 * @Author 18050909
 * @Date 2020/5/21 11:50
 * @Version 1.0
 **/
public class StackDeep {
    private static int count = 0;
    public static void main(String[] args) {
        try{
            //reserve();
            reserve(0,1,2);
        }catch (Throwable e){
            System.out.println("deepCount="+count);
        }
    }
    /**6+3 9个局部变量表*/
    private static void reserve(int i, int i1, int i2) {
        int a=1,b=2,c=3,d=4,e=5,f=6;
        count++;
        reserve(a,b,c);
    }

    private static void reserve() {

        Object o = new Object();
        count++;
        reserve();
    }


}
