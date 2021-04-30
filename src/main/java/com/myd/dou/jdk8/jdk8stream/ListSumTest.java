package com.myd.dou.jdk8.jdk8stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/27 20:04
 * @Description:
 *
private final Supplier<A> supplier;
private final BiConsumer<A, T> accumulator;
private final BinaryOperator<A> combiner;
private final Function<A, R> finisher;
private final Set<Characteristics> characteristics;

 */
public class ListSumTest {
    public static void main(String[] args) {
        Num num1 = new Num(new BigDecimal(1),new BigDecimal(1),new BigDecimal(1));
        Num num2 = new Num(new BigDecimal(2),new BigDecimal(2),new BigDecimal(2));
        Num num3 = new Num(new BigDecimal(3),new BigDecimal(4),new BigDecimal(5));
        Num num4 = new Num(null,null,new BigDecimal(5));

        List<Num> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        list.add(num4);

        BigDecimal costSum = list.stream()
                .filter(o->o.getCost()!=null)
                .map(re -> re.getCost())
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        Optional<BigDecimal> reduce = list.stream()
                .filter(o->o.getCost()!=null)
                .map(re -> re.getCost())
                .reduce(BigDecimal::add);

        System.out.println(costSum);
        System.out.println(reduce.get());




    }
}
