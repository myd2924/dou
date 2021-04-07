package com.myd.dou.jdk8.other;

import com.myd.dou.dto.User;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/8/4 16:41
 * @Description: Optional 一个容器对象
 */
public class OptionTest {
    public static void main(String[] args) {
        //Optional<User> useOption =  Optional.of(null);
        Optional<User> useOption = Optional.empty();

        User user = useOption.orElse(User.builder().name("daxi").build());
        System.out.println(user);

        Optional<User> op = Optional.empty();

        System.out.println(Optional.ofNullable(null).toString());


    }
}
