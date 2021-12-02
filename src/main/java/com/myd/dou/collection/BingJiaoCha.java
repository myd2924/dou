package com.myd.dou.collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/12/2 15:22
 * @Description: 并集、交集 差集
 */
public class BingJiaoCha {

    /**
     * 差集
     */
    @Test
    public void differenceTest(){
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");

        set2.add("a");
        set2.add("b");
        set2.add("c");
        set2.add("d");
        set2.add("e");


        final boolean b = set1.removeAll(set2);
        System.out.println("结果："+b);
        System.out.println("set1:"+set1);
        System.out.println("set2:"+set2);

    }

    /**
     * 并集
     */
    @Test
    public void unionSetTest(){
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");

        set2.add("e");
        set2.add("f");
        set2.add("c");
        set2.add("d");


        final boolean b = set1.addAll(set2);
        System.out.println("结果："+b);
        System.out.println("set1:"+set1);
        System.out.println("set2:"+set2);

    }

    /**
     * 交集
     */
    @Test
    public void intersectionTest(){
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");

        set2.add("e");
        set2.add("f");
        set2.add("c");
        set2.add("d");


        final boolean b = set1.retainAll(set2);
        System.out.println("结果："+b);
        System.out.println("set1:"+set1);
        System.out.println("set2:"+set2);

    }

}
