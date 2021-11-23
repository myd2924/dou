package com.myd.dou.nulltest;

import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/5 11:23
 * @Description: TODO
 */
public class ListNullTest {
    public static void main(String[] args) {
        List<Object> list  = null;
        for(Object o : list){//java.lang.NullPointerException
            System.out.println(o);
        }
    }
}
