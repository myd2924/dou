package com.myd.dou.jdk8.jdk8stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/7/24 17:25
 * @Description: 流测试
 */
public class MainTest1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        list.stream().filter(s -> !s.isEmpty()).forEach(System.out::println);

        Random random = new Random();
        random.ints().limit(2).forEach(System.out::println);

        List<Integer> intege = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        intege.stream().map(i -> i*i).distinct().forEach(System.out::println);
    }
}
