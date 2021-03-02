package com.myd.dou.jdk8.fiter;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/10/30 13:56
 * @Description: TODO
 */
public class Test1 {
    public static void main(String[] args) {

        List<String> list = null;
        for(String s:list){
            System.out.println("");
        }
        System.out.println("list可以为null");

        System.out.println("1,2".indexOf("2"));

        Map<String,Object> map = new HashMap<>();

        map.put("cost",new BigDecimal("3.23"));
        BigDecimal b = (BigDecimal)map.get("cost");
        Object cost = map.get("cost");
        System.out.println(cost);






    }

    public static String cutImagesBrackets(final String img){
        if(StringUtils.isNotEmpty(img)){
            return img.replaceFirst("\\[","").replace("]","");
        }
        return "";
    }
}
