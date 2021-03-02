package com.myd.dou.jvm.two;

/**
 * @ClassName LocalVarGC
 * @Description 局部变量gc
 * @Author 18050909
 * @Date 2020/5/21 17:26
 * @Version 1.0
 **/
public class LocalVarGC {
    public static void main(String[] args) {
        LocalVarGC gc = new LocalVarGC();
        gc.LocalVarGC5();

    }
    //基本没变
    public void LocalVarGC1(){
        Byte[] bytes = new Byte[6*1024*1024];
        System.gc();
    }
    //会gc
    public void LocalVarGC2(){
        Byte[] bytes = new Byte[6*1024*1024];
        bytes = null;
        System.gc();
    }

    public void LocalVarGC3(){
        {
            Byte[] bytes = new Byte[6*1024*1024];
        }

        System.gc();
    }

    public void LocalVarGC4(){
        {
            Byte[] bytes = new Byte[6*1024*1024];
        }
        int b = 10;
        System.gc();
    }

    public void LocalVarGC5(){
        LocalVarGC1();
        System.gc();
    }

}
