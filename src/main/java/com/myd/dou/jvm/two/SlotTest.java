package com.myd.dou.jvm.two;

/**
 * @ClassName SlotTest
 * @Description
 * locakVar1 槽位不复用
 * locakVar2 槽位复用
 * @Author 18050909
 * @Date 2020/5/21 17:17
 * @Version 1.0
 **/
public class SlotTest {
    public static void main(String[] args) {
        locakVar1();
        locakVar2();
    }

    public static void locakVar2() {
        {
            int a = 0;
            System.out.println(a);
        }
        int b = 0;
    }

    public static void locakVar1() {
        int a = 0;
        System.out.println(a);
        int b = 0;
    }
}
