package com.myd.dou.util;

import java.util.regex.Pattern;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/9/15 18:10
 * @Description: 校验正整数
 */
public class CheckNumber {
    public static void main(String[] args) {
        //System.out.println(positiveInteger("5.0000"));
        System.out.println(checkPositiveInteger("50.1"));
    }

    protected static boolean positiveInteger(String str){
        String theOne = str.substring(0, 1);
        if("0".equals(theOne)||"-".equals(theOne)){
            return false;
        }
        Pattern pattern = Pattern.compile("^\\d+(\\.\\d{0,3})?");
        return pattern.matcher(str).matches();
    }

    protected static boolean checkPositiveInteger(String str){
        String theOne = str.substring(0, 1);
        if("0".equals(theOne)||"-".equals(theOne)){
            return false;
        }
        Pattern pattern = Pattern.compile("^\\d+(\\.[0]{0,3})?");
        return pattern.matcher(str).matches();
    }
}
