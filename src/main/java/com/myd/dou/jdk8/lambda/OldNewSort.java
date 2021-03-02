package com.myd.dou.jdk8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Classname OldNewSort
 * @Description 新老版本排列 对比
 * @Date 2020/7/23 11:40
 * @Created by mayd
 */
public class OldNewSort {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("peter", "anna", "mike", "xenia");

        System.out.println("sort before "+list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("sort after "+list);

        /**lambda表达式 三种写法*/
        List<String> listnew = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(listnew,(a,b)-> a.compareTo(b));
        //Collections.sort(listnew,(a,b)-> {return a.compareTo(b);});
        //Collections.sort(listnew,(String a,String b)-> a.compareTo(b));
        System.out.println("sort after "+listnew);
    }

}
