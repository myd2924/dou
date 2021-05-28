package com.myd.dou.jdk8.lambda.supplier;

import com.myd.dou.dto.User;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/5/18 11:04
 * @Description:
 */
public class ListTest {
    public static void main(String[] args) {

        BigDecimal a = new BigDecimal(21.1000);
        BigDecimal b = new BigDecimal(21.00);
        BigDecimal c = new BigDecimal(21.0000);
        System.out.println(calcNewBigValue(a));
        System.out.println(calcNewBigValue(b));
        System.out.println(calcNewBigValue(c));

        String hh =  "";
        String kk = "";
        System.out.println();
        System.out.println(hh.equals(""));

        User user = new User();
        user.setName(null);
        System.out.println(user.getName());

    }

    private static String calcNewBigValue(BigDecimal totalQuantity) {
        if(Objects.isNull(totalQuantity)){
            return "0";
        }
        String content = totalQuantity.setScale(3, BigDecimal.ROUND_DOWN).toPlainString();
        if(content.endsWith(".000")){
            return totalQuantity.toPlainString();
        }
        return content;
    }

}
