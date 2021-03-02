package com.myd.dou.jvm.three;

import java.util.Vector;

/**
 * @ClassName DumpOOM
 * @Description -Xmx20m -Xms20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:/changyong/MemoryAnalyzer-1.8.0.20180604-win32.win32.x86_64/a.dump
 * @Author 18050909
 * @Date 2020/5/21 18:51
 * @Version 1.0
 **/
public class DumpOOM {
    public static void main(String[] args) {
        Vector v = new Vector();
        for(int i=0;i<25;i++){
            v.add(new byte[1*1024*1024]);
        }
    }
}
