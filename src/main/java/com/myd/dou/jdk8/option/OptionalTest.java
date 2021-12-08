package com.myd.dou.jdk8.option;

import com.myd.dou.dto.User;

import java.util.Optional;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/2/3 09:35
 * @Description:
 */
public class OptionalTest {
    public static void main(String[] args) {
        User user = queryById();
        System.out.println(Optional.ofNullable(user).orElse(new User("2","ff",4)));
        User user2 = new User();
        final Optional<Integer> integer = Optional.ofNullable(user2)
                .map(o -> o.getAge());
        if(integer.isPresent()){
            final Integer integer1 = integer.get();
            System.out.println("****");
        }

        final Object o = Optional.ofNullable(null).orElse(new Object());
        System.out.println(o);

    }


    /**
     * 模拟查库
     * @return
     */
    private static User queryById() {
        return null;
    }
}
