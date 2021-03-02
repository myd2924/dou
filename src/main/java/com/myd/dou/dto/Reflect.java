package com.myd.dou.dto;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/9/3 21:05
 * @Description: TODO
 */
public class Reflect {
    public static void main(String[] args) {
        Field[] declaredFields = User.class.getDeclaredFields();
        System.out.println(declaredFields[0].getName());
        System.out.println(declaredFields[1].getName());

        String str = "200.0";
        String str2 = "300";
        System.out.println(str2.indexOf("."));
        int i = str.indexOf(".");
        String substring = str.substring(0, i);
        System.out.println(substring);

        Set<String> set = new HashSet<>();
        boolean add = set.add("11");
        System.out.println(add);
        boolean add1 = set.add("11");
        System.out.println(add1);

    }
}
