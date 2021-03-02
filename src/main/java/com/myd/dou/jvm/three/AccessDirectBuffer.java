package com.myd.dou.jvm.three;

import java.nio.ByteBuffer;

/**
 * @ClassName AccessDirectBuffer
 * @Description 直接内存 -XX:MaxDirectMemorySize 不设置 默认堆最大内存即-Xmx
 * 一般来说 读写访问速度 directAccess>bufferAccess 但是分配空间directAccess<bufferAccess
 * @Author 18050909
 * @Date 2020/5/21 19:07
 * @Version 1.0
 **/
public class AccessDirectBuffer {
    /**直接内存*/
    public void directAccess(){
        long start = System.currentTimeMillis();
        ByteBuffer by = ByteBuffer.allocateDirect(500);
        for(int i=0;i<100000;i++){
            for(int j=0;j<99;j++){
                by.putInt(j);
            }
            /**buffer从写模式切换到读模式*/
            by.flip();
            for(int j=0;j<99;j++){
                by.get(j);
            }
            /**buffer清空*/
            by.clear();
        }
        long end = System.currentTimeMillis();
        System.out.println("directAccess cost time:"+(end-start));
    }
    /**堆内存*/
    public void bufferAccess(){
        long start = System.currentTimeMillis();
        ByteBuffer by = ByteBuffer.allocate(500);
        for(int i=0;i<100000;i++){
            for(int j=0;j<99;j++){
                by.putInt(j);
            }
            /**buffer从写模式切换到读模式*/
            by.flip();
            for(int j=0;j<99;j++){
                by.get(j);
            }
            /**buffer清空*/
            by.clear();
        }
        long end = System.currentTimeMillis();
        System.out.println("bufferAccess cost time:"+(end-start));
    }

    public static void main(String[] args) {
        AccessDirectBuffer db = new AccessDirectBuffer();
        db.directAccess();
        db.bufferAccess();

        db.directAccess();
        db.bufferAccess();
    }
}
