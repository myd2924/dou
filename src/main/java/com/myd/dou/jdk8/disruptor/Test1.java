package com.myd.dou.jdk8.disruptor;


import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/6/9 10:51
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> billEnums = null;
        final List<Integer> billIds = new ArrayList<>(CollectionUtils.size(billEnums));
        System.out.println(billIds.isEmpty());

    }
}
