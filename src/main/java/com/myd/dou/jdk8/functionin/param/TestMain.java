package com.myd.dou.jdk8.functionin.param;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/4/30 09:36
 * @Description: 牛逼的设计  接口参数化  真正抽象的使用
 */
public class TestMain {

    public static void main(String[] args) {
        List<Stu> list = new ArrayList<>();
        list.add(new Stu("da","泗洪",3,"28"));
        list.add(new Stu("er","南京",4,"32"));
        list.add(new Stu("san","南昌",5,"12"));

        ListConvert<List<Stu>,Person.PersonBuilder,List<Person>> function = (t,k,r)-> t.stream().map(o->k.name(o.getName()).age(o.getAge()).addres(o.getAddres()).build()).collect(Collectors.toList());
        List<Person> result = function.convert(list, new Person.PersonBuilder(), new ArrayList<>());
        System.out.println(result.get(0).getAddres());
    }






}
