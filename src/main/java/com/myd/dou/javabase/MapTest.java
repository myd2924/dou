package com.myd.dou.javabase;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/12/6 11:16
 * @Description:
 * treemap  安key 排序
 * hashmap 散列无序
 * linkedHashmap  按插入顺序
 */
public class MapTest {

    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        map.put("1","一号");
        map.put("3","三号");
        map.put("2","二号");
        map.put("4","四号");

        System.out.println(map);
        System.out.println(map.keySet());

        /**
         * 自定义比较器
         */
        TreeMap<String,String> mapCom = new TreeMap(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

    }

    @Test
    public void hashTest(){
        HashMap map = new HashMap(4);
        map.put("ma","一号");
        map.put("ding","三号");
        map.put("cheng","二号");
        map.put("xi","四号");

        System.out.println(map);
        System.out.println(map.keySet());
    }

    @Test
    public void linkedHash(){
        LinkedHashMap map = new LinkedHashMap(4);
        map.put("1","一号");
        map.put("3","三号");
        map.put("2","二号");
        map.put("4","四号");

        System.out.println(map);
        System.out.println(map.keySet());
    }

}
