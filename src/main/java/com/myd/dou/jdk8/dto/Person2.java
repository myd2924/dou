package com.myd.dou.jdk8.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/11/30 09:34
 * @Description: TODO
 */
@Data
@Builder
public class Person2 {
    /**
     * 别称
     */
    private List<String> names;

    private String id;

    private String name;


}
