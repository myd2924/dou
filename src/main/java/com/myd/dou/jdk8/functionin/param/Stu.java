package com.myd.dou.jdk8.functionin.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/30 09:35
 * @Description: TODO
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Stu {
    private String name;

    private String addres;

    private int age;

    private String no;
}
