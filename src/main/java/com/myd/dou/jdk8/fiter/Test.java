package com.myd.dou.jdk8.fiter;

import com.myd.dou.dto.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/10/29 19:39
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(
                new User("1","da",5),
                new User("2","er",3),
                new User("3","san",1));

        List<User> collect = list.stream().filter(u -> u.getId().equals("1")).collect(Collectors.toList());
        Map<String, User> er = list.stream().filter(u -> u.getName().equals("er")).collect(Collectors.toMap(User::getId, User -> User));
        System.out.println(collect.get(0));
        System.out.println(er.get("2"));
    }
}
