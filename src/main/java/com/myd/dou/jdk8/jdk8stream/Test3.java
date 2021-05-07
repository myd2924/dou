package com.myd.dou.jdk8.jdk8stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/5/6 15:55
 * @Description:
 */
public class Test3 {
    public static void main(String[] args) {
        List<User2> list = new ArrayList<>();
        list.add(new User2(null,"da"));
        list.add(new User2(null,"er"));

        Map<String, BigDecimal> collect = list.stream()
                .collect(Collectors.toMap(User2::getName, User2::getProcessAge));

        System.out.println(collect);
    }
}
