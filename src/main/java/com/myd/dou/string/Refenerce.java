package com.myd.dou.string;

import com.myd.dou.EnumTest;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/12/4 14:00
 * @Description: TODO
 */
public class Refenerce {
    public static void main(String[] args) {

        boolean done = EnumTest.DONE.equals("DONE");
        System.out.println(done);
        //toPlainString() 直接显示  不使用科学计数法  0.00001
        //toString() 使用科学计数法   1.0E-5
        System.out.println(BigDecimal.ZERO.toPlainString().equals("0"));

        BigDecimal total = new BigDecimal(0);
        BigDecimal one = new BigDecimal(2);
        total.add(one);
        System.out.println(total);

        System.out.println(total.subtract(one));

        System.out.println(new Date());
    }
}
