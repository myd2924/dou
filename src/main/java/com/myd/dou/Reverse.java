package com.myd.dou;

/**
 * @ClassName Reverse
 * @Description TODO
 * @Author 18050909
 * @Date 2020/5/14 14:59
 * @Version 1.0
 **/
public class Reverse {
    public static void main(String[] args) {
        String ss = "731729641";
        StringBuilder sb = new StringBuilder(ss);
        String reverse = sb.reverse().toString();
        System.out.println(reverse);

    }
}
