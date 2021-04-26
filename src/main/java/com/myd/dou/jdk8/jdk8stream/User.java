package com.myd.dou.jdk8.jdk8stream;

import lombok.Data;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/21 11:18
 * @Description:
 */
@Data
public class User {
    private int sequenceNo;
    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
