package com.myd.dou.reflect;

import com.myd.dou.annotation.ExcelField;
import com.myd.dou.dto.User;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/3/30 17:46
 * @Description:
 */
public class ReflectTest2 {

    public static void main(String[] args) throws IllegalAccessException {
        UserBean bean = new UserBean();
        bean.setId("1");
        bean.setName("妈妈");
        bean.setPrice(new BigDecimal(5.2));

        List<UserBean> beanList = new ArrayList<>();
        beanList.add(bean);

        Field[] declaredFields = bean.getClass().getDeclaredFields();
        System.out.println(declaredFields[0]);
        declaredFields[0].setAccessible(true);
        String name = declaredFields[0].getName();
        System.out.println(name);
        ExcelField annotation = declaredFields[0].getAnnotation(ExcelField.class);
        System.out.println(annotation.headerName());
        Object o = declaredFields[0].get(bean);
        System.out.println(o);


    }

}
