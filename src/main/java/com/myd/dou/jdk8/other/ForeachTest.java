package com.myd.dou.jdk8.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/10/30 11:11
 * @Description: TODO
 */
public class ForeachTest {
    public static void main(String[] args) {
        List<String> lsit = Arrays.asList("2","3","4");
        List<String> lsit2 = Arrays.asList("2","3","4");
        List<Integer> result = new ArrayList<>();
        lsit.forEach(re -> {
            final Integer integer = Integer.valueOf(re);
            if(integer == 3){
                result.add(integer);
                return;
            }
        });
        lsit2.forEach(re->{
            lsit2.forEach(k->{
                if(Integer.valueOf(k) == 3){
                    System.out.println(re+k);
                    return ;
                }
            });
            System.out.println(re);
        });

    }
}
