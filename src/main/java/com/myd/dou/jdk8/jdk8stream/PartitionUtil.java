package com.myd.dou.jdk8.jdk8stream;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/9/18 09:48
 * @Description: 切分工具 List 切分成几个小的list
 * @UtilityClass == final + static
 */
@UtilityClass
public class PartitionUtil {

    public <T> List<List<T>> partition(final List<T> list, final int size){
        return IntStream.range(0,list.size())
                .boxed()//装箱
                .filter(i->i%size == 0)//把几个节点摘出来
                .map(k->list.stream().skip(k).limit(size).collect(Collectors.toList())) //截取list
                .collect(Collectors.toList());//封装成List<List<T>>
    }

    public <T> Set<Set<T>> partition(final Set<T> list, final int size){
        return IntStream.range(0,list.size())
                .boxed()//装箱
                .filter(i->i%size == 0)//把几个节点摘出来
                .map(k->list.stream().skip(k).limit(size).collect(Collectors.toSet())) //截取list
                .collect(Collectors.toSet());//封装成List<List<T>>
    }

}
