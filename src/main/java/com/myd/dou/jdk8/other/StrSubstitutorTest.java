package com.myd.dou.jdk8.other;

import org.apache.commons.lang3.text.StrSubstitutor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/8/13 19:34
 * @Description:
 * StrSubstitutor是一个很特殊的类，它使用${}的方法在形成了一个可配置的模板String。
 * 首先可以用一个Map声明一个 StrSubstitutor，然后使用replace方法，
 * {}的部分（内部为Map的key)，转化为Map中的值，由此 做到动态更改字符串内容的效果
 */
public class StrSubstitutorTest {
    public static void main(String[] args) {
        Map valMap = new HashMap();
        valMap.put("father","mayuanding");
        valMap.put("daughter","machenxi");
        String strTemplte = "${daughter} is ${father} de child";
        StrSubstitutor substitutor = new StrSubstitutor(valMap);
        String replace = substitutor.replace(strTemplte);
        System.out.println(replace);//machenxi is mayuanding de child
    }
}
