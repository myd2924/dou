package com.myd.dou.jdk8.functionin;

/**
 * @Classname Main
 * @Description 测试函数式接口
 * @Date 2020/7/23 13:59
 * @Created by mayd
 */
public class Main {
    public static void main(String[] args) {
        Converter<String,Integer> strToInteger = (from)-> Integer.parseInt(from);
        Integer conver = strToInteger.conver("123");
        System.out.println(conver);
        System.out.println(strToInteger.sqrt(16));

        Str2Int str2Int = new Str2Int();
        Integer conver1 = str2Int.conver("345");
        System.out.println(conver1);



    }
}
