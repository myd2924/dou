package com.myd.dou.jdk8.jdk8stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/9/18 10:04
 * @Description:
 */
public class PartitionUtilTest {
    public static void main(String[] args) {
        List<Integer> list = IntStream.iterate(0,k->k+2).limit(54).boxed().collect(Collectors.toList());
        final List<List<Integer>> partition = PartitionUtil.partition(list, 10);
        System.out.println(partition);
    }
}
