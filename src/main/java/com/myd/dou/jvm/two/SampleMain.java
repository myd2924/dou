package com.myd.dou.jvm.two;

/**
 * @ClassName SampleMain
 * @Description  20M
 * -Xmx20m 堆最大大小20M
 * -Xms20m 初始化堆大小20M
 * @Author 18050909
 * @Date 2020/5/21 11:35
 * @Version 1.0
 **/
public class SampleMain {
    public static void main(String[] args) {
        if(args.length>0){
            for (int i=0;i<args.length;i++){
                System.out.println("args"+(i+1)+" = " + args[i]);
            }
        }
        System.out.println(Runtime.getRuntime().maxMemory()/1000/1000+"M");
    }
}
