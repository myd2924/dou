package com.myd.dou.jdk8.functionin;

/**
 * @Classname Str2Int
 * @Description
 * @Date 2020/7/23 14:07
 * @Created by mayd
 */
public class Str2Int implements Converter<String,Integer>{

    @Override
    public Integer conver(String from) {
        return Integer.parseInt(from);
    }
}
