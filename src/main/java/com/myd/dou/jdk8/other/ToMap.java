package com.myd.dou.jdk8.other;

import com.myd.dou.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/8/12 16:39
 * @Description: Collectors.toMap
 * Function.identity()  ==  t -> t 返回一个输出跟输入一样的Lambda表达式对象
 */
public class ToMap {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(User.builder().id("1").name("daxi").age(4).build());
        list.add(User.builder().id("1").name("daxi111").age(100).build());
        list.add(User.builder().id("2").name("erxi").age(3).build());

        //(i1,i2)->i1 解决同一个key报错问题
        Map<String, User> userMap = list.stream().collect(Collectors.toMap(User::getId, Function.identity(),(i1,i2)->i1));

        //Map<String, User> userMap2 = list.stream().collect(Collectors.toMap(User::getId, (user)-> user));
        System.out.println(userMap);
        //System.out.println(userMap2);
    }
}
