package com.myd.dou.jvm.three;

import java.nio.ByteBuffer;

/**
 * @ClassName AllocDirectBuffer
 * @Description 分配空间 直接内存更耗时
 * allocateBuffer cost time:61
   allocateDirect cost time:123
 * @Author 18050909
 * @Date 2020/5/21 19:35
 * @Version 1.0
 **/
public class AllocDirectBuffer {
    public void allocateDirect(){
        long start = System.currentTimeMillis();
        for(int i=0;i<200000;i++){
            ByteBuffer bf = ByteBuffer.allocateDirect(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("allocateDirect cost time:"+(end-start));
    }

    public void allocateBuffer(){
        long start = System.currentTimeMillis();
        for(int i=0;i<200000;i++){
            ByteBuffer bf = ByteBuffer.allocate(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("allocateBuffer cost time:"+(end-start));
    }

    public static void main(String[] args) {
        AllocDirectBuffer db = new AllocDirectBuffer();
        db.allocateBuffer();
        db.allocateDirect();
    }
}
