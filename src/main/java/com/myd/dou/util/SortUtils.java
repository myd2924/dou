package com.myd.dou.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/10/23 16:32
 * @Description: TODO
 */
public class SortUtils {

    public static List sort(Map map){

        final ArrayList<Integer> arrayList = new ArrayList<>(map.keySet());
        arrayList.sort((a, b)->{
            if(a.compareTo(b)<0){
                return a;
            }
            return b;
        });

        return arrayList;
    }

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap(4);
        map.put(1,"a");
        map.put(0,"b");
        map.put(2,"c");
        final List sort = sort(map);
        System.out.println(sort);

    }

}
