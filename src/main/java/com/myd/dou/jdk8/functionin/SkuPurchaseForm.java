package com.myd.dou.jdk8.functionin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/26 19:22
 * @Description:
 */
@Getter
@Setter
@NoArgsConstructor
public class SkuPurchaseForm {

    private String name;
    private int age;
    private String school;

    private List<AddreForm> addreList;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class AddreForm{
        private String addName;
        private String addCode;
    }

}
