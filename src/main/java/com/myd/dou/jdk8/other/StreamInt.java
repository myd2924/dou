package com.myd.dou.jdk8.other;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/8/20 14:22
 * @Description: TODO
 */
public class StreamInt {
    public static void main(String[] args) {
        final String field = IntStream.range(0, "1002".length() / 4).boxed().map(l -> "childs").collect(Collectors.joining("|")) + "|id";
        
        System.out.println(field);
        IntStream.range(0, "1002".length() / 4);
        Stream<Integer> boxed = IntStream.range(0, "1002".length() / 4).boxed();
    }
}
