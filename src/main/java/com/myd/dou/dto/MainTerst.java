package com.myd.dou.dto;

import com.myd.dou.jdk8.functionin.param.Stu;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/10/15 17:43
 * @Description: TODO
 */
public class MainTerst {
    public static void main(String[] args) {
        final ResponseTest responseTest = new ResponseTest(new Stu(), null);
        System.out.println(responseTest);
    }
}
