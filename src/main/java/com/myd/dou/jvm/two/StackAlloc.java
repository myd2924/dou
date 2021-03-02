package com.myd.dou.jvm.two;

import com.myd.dou.dto.User;

/**
 * @ClassName StackAlloc
 * @Description 栈上分配
 * -server -Xmx20m -Xms20m -XX:+PrintGC -XX:+DoEscapeAnalysis -XX:+EliminateAllocations -XX:-UseTLAB
 * 逃逸对象  no
 * 非逃逸对象 yes
 * @Author 18050909
 * @Date 2020/5/21 17:40
 * @Version 1.0
 **/
public class StackAlloc {
    public static class Stu{
        public int age =0;
        public String name = "";
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static void alloc() {
        Stu stu = new Stu();
        stu.age = 1;
        stu.name = "masan";
    }

    private User u;
    /**逃逸对象分配在堆上*/
    public void escapeObject(){
        u = new User();
        u.setName("11");
    }

    public void noEscapeObject(){
        User u = new User();
        u.setName("12");
    }

}
