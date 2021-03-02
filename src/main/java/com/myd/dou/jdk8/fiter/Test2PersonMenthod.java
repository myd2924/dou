package com.myd.dou.jdk8.fiter;

import com.myd.dou.jdk8.convert.Convert;
import com.myd.dou.jdk8.dto.Person;
import com.myd.dou.jdk8.dto.Person2;
import com.myd.dou.jdk8.response.CentreListResponse;
import com.myd.dou.jdk8.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/11/30 09:21
 * @Description: 测试簇方法
 */
public class Test2PersonMenthod {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(Person.builder().name("daxi").id("1").build());
        list.add(Person.builder().name("daxi2").id("1").build());
        list.add(Person.builder().name("daxi3").id("1").build());
        list.add(Person.builder().name("erxi").id("2").build());
        list.add(Person.builder().name("erxi2").id("2").build());

        CentreListResponse<Person2> personResponse = Response.toListResponse(list, Convert::toDTO);

        List<Person2> dataList = personResponse.getDataList();

        Map<String, String> collect = list.stream()
                .collect(Collectors.toMap(Person::getId, Person::getName, (oldV,newV) -> oldV + "," + newV));
        System.out.println(collect.get("1"));
        System.out.println(collect.get("2"));


    }
}
