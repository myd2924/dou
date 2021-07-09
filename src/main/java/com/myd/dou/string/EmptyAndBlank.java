package com.myd.dou.string;

import org.apache.commons.lang3.StringUtils;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/7/1 15:48
 * @Description:
 */
public class EmptyAndBlank {
    public static void main(String[] args) {
        String a = "   ";
        String b = "";
        String c = null;

        //false  会计算空格
        System.out.println(StringUtils.isEmpty(a));
        //true
        System.out.println(StringUtils.isEmpty(b));
        //true
        System.out.println(StringUtils.isEmpty(c));

        //true 会去空格
        System.out.println(StringUtils.isBlank(a));
        //true
        System.out.println(StringUtils.isBlank(b));
        //true
        System.out.println(StringUtils.isBlank(c));

    }
}
