package com.myd.dou.jdk8.reference;

import com.myd.dou.jdk8.dto.Person;
import com.myd.dou.jdk8.functionin.Converter;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2020/7/23 14:30
 * @Created by mayd
 */
public class Main {
    public static void main(String[] args) {
        String str = "absd";
        Converter<String,Integer> hh = Integer::parseInt;
        Integer conver = hh.conver("3333");

        Person person = new Person();
        person.setAge(4);
        person.setName("daxi");

    }
}
