package com.myd.dou.bigdecimal;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/7/30 19:49
 * @Description: 数值精度问题
 */
public class Main {
    public static void main(String[] args) {

        BigDecimal a = new BigDecimal(10);
        BigDecimal k = new BigDecimal(31);
        System.out.println(a.divide(k,2,BigDecimal.ROUND_DOWN));

        a.multiply(null);



    }
}
