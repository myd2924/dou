package com.myd.dou.other;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2022/2/11 18:12
 * @Description: TODO
 */
public class StirngTet {
    public static void main(String[] args) {
        String str = "";
        final String[] split = str.split(",");
        for(String string : split){
            System.out.println(string);
        }

        final List<String> list = JSONArray.parseArray("[18061669891]", String.class);
        String[] re = new String[list.size()];
        final String[] strings = list.toArray(re);
        System.out.println(re);
        System.out.println(strings);

        final int i = RandomUtils.nextInt(0, 10);
        System.out.println(i);
        String kk = "ONE";
        switch (kk){
            case "ONE":
                System.out.println("one");
                break;
            case "TWO":
                System.out.println("two");
                break;
                default:
                    System.out.println("default");
        }
    }
}
