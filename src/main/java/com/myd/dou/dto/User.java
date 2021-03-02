package com.myd.dou.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author 18050909
 * @Date 2020/4/26 11:26
 * @Version 1.0
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User implements Serializable{


    private static final long serialVersionUID = -8249028833558352818L;

    /**唯一标识*/
    private String id;

    /**姓名*/
    private String name;

    /**年级*/
    private transient int age;


    public int doSomething(){
        int a = 1;
        System.out.println(a);
        return a;
    }

}
