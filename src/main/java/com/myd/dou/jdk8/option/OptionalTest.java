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
    }


    /**
     * 模拟查库
     * @return
     */
    private static User queryById() {
        return null;
    }
}
