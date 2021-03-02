package com.myd.dou.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/8/12 11:07
 * @Description: TODO
 */
public class HashSetTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("11");
        list.add("11");
        list.add("22");
        list.add("22");
        list.add("22");

        HashSet hashSet = new HashSet<>(list);
        System.out.println(hashSet);
        List<String> distinct = new ArrayList<>(new HashSet<>(list));
        List<String> distinct1 = new ArrayList<>();
        distinct1.addAll(hashSet);
        System.out.println(distinct1);
        System.out.println(distinct);
        System.out.println(list);

    }
}
