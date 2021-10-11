package com.myd.dou.javabase;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/9/24 14:05
 * @Description:
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        //禁止使用构造方法BigDecimal(double)的方式把double值转化为BigDecimal对象
        // 说明：反编译出的字节码文件显示每次循环都会new出一个StringBuilder对象，
        // 然后进行append操作，最后通过toString方法返回String对象，造成内存资源浪费。

        //BigDecimal kk = new BigDecimal(1212.2323);
        BigDecimal kk = new BigDecimal("1212.2323");
        //返回个新值，自己并没有变
        final BigDecimal decimal = kk.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(kk);
        System.out.println(decimal);
        Pattern pattern = null;
        Object value = -1;
        String regex = "([1-9]\\d*(\\.\\d{1," + value + "})?)|(0(\\.\\d{1," + value + "})?)";
        pattern = Pattern.compile(regex);
    }
}
