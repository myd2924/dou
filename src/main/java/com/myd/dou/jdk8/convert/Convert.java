package com.myd.dou.jdk8.convert;

import com.myd.dou.jdk8.dto.Person;
import com.myd.dou.jdk8.dto.Person2;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/11/30 09:52
 * @Description:
 */
@UtilityClass
public class Convert {

    public  <T extends Person> Person2 toDTO(T source){

        Person2 person2 = Person2.builder()
               .id(source.getId())
               .name(source.getName())
               .names(new ArrayList<>())
               .build();
        person2.getNames().add(source.getName());
       return person2;

   }
}
