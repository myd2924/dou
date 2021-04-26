package com.myd.dou.jdk8.jdk8stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/21 11:18
 * @Description: list分组
 */
public class ListSplite {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User(1, "大"),
                new User(2, "大"),
                new User(3, "二"),
                new User(4, "二"));
        //map 分组
        Map<String, List<User>> map = users.stream().collect(Collectors.groupingBy(User::getName, Collectors.toList()));
        map.forEach((x,y)-> System.out.println(x+" "+y) );

        AtomicInteger count = new AtomicInteger(0);
        List<User> collect = users.stream()
                .map(u -> {
                    u.setSequenceNo(count.incrementAndGet());
                    return u;
                })
                .collect(Collectors.toList());
        System.out.println(collect);

        List<String> list = new ArrayList<>();
        list.add("45");
        list.add("455");
        list.add("df");
        StringBuilder builder = new StringBuilder();
        for(String str:list){
            builder.append(str).append(",");
        }
        System.out.println(builder.toString());
        System.out.println(builder.toString().substring(0,builder.toString().lastIndexOf(",")));
        StringBuilder builder2 = new StringBuilder();
        System.out.println(builder2.toString().substring(0,builder2.toString().lastIndexOf(",")));
    }
}
