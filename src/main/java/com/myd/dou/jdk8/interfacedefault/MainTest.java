package com.myd.dou.jdk8.interfacedefault;

import com.myd.dou.jdk8.dto.Person;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/7/23 16:45
 * @Description: 访问接口的默认方法
 */
public class MainTest {
    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length()>0;
        boolean hhh = predicate.test("hhh");
        boolean negate = predicate.negate().test("hhh");

        System.out.println(hhh);
        System.out.println(negate);

        //Comsumer接口
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getName());
        //greeter.accept(new Person("Luke", 5));

        //Optional接口
        Optional<String> optional = Optional.of("bam");
        System.out.println(optional.isPresent());           // true
        System.out.println(optional.get());                 // "bam"
        System.out.println(optional.orElse("fallback"));    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"


    }
}
