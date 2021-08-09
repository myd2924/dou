package com.myd.dou.jdk8.jdk8stream;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/10/23 16:27
 * @Description: TODO
 */
public class Test1 {
    public static void main(String[] args) {
        UUID.randomUUID().toString();
        System.out.println(UUID.randomUUID().toString().replace("-",""));

        List<User> list = new ArrayList<>();
        final Map<String, Integer> map = list.stream().collect(Collectors.toMap(User::getName, User::getAge));
        System.out.println(map == null);
        System.out.println(Optional.ofNullable(map.get("hha")).orElse(0));

        String shsh = "ndsjhkjdhskh";
        System.out.println(shsh.indexOf("hs"));
        //System.out.println(shsh.indexOf(null));
        final BigDecimal bigDecimal = new BigDecimal(8.0);
        System.out.println(calcNewBigValue(new BigDecimal(8.00000)));
        System.out.println(calcNewBigValue(bigDecimal));
    }

    protected static String calcNewBigValue(BigDecimal totalQuantity) {
        if(Objects.isNull(totalQuantity)){
            return "0";
        }
        String content = totalQuantity.setScale(3, BigDecimal.ROUND_HALF_UP).toPlainString();
        if(content.endsWith(".000")){
            return totalQuantity.toPlainString();
        }
        return content;
    }
}
