package com.myd.dou.jvm.eight;

/**
 * @ClassName LockEliminate
 * @Description 锁消除
 * -server -XX:+DoEscapeAnalysis -XX:-EliminateLocks -XX:BiasedLockingStartupDelay=0
 * -XX:-EliminateLocks 120
 * -XX:+EliminateLocks 88
 * @Author 18050909
 * @Date 2020/5/23 16:02
 * @Version 1.0
 **/
public class LockEliminate {
    private static final int CIRCLE = 2000000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i=0;i<CIRCLE;i++){
            cretarBuiffer("JVM","mtyd");
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static String cretarBuiffer(String s1, String s2) {
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }
}
