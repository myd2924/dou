package com.myd.dou.reflect;

import lombok.*;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/10/11 14:48
 * @Description: 反射po
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyReflect {

    private String name;

    private Integer age;

    private String hobby;

    public String puMethod(String name){
        return name + ": public,hello，你的名称是" + this.getName();
    }

    protected String proMethod(Integer age){
        return age + " ：protected 年纪几许 " + this.getAge();
    }

    private String priMethod(String boby){
        return boby + ": private  就这么点爱好--" + this.getHobby();
    }

    public static String staticMethod(String staticData){
        return "静态方法"+staticData;
    }

}
