package com.myd.dou.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2022/2/14 16:44
 * @Description: 校验工具类
 */
@UtilityClass
public class ValidateUtils {
    private final String REGEX_MOBILE ="((\\+86|0086)?\\s*)((134[0-8]\\d{7})|(((13([0-3]|[5-9]))|(14[5-9])|15([0-3]|[5-9])|(16(2|[5-7]))|17([0-3]|[5-8])|18[0-9]|19(1|[8-9]))\\d{8})|(14(0|1|4)0\\d{7})|(1740([0-5]|[6-9]|[10-12])\\d{7}))";


    /**
     * 判断是否是手机号
     * @param tel 手机号
     * @return boolean true:是  false:否
     */
    public boolean isMobile(String tel) {
        if (StringUtils.isEmpty(tel)){
            return false;
        }
        return Pattern.matches(REGEX_MOBILE, tel);
    }

    public static void main(String[] args) {
        String str = "18061669892,18652009952";
        String hh = "[]";
        System.out.println(hh.substring(1,1));
        System.out.println(isMobile("18652009955"));


    }
}
