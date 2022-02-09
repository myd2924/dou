package com.myd.dou.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ReflectionUtils;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2022/2/9 17:19
 * @Description: TODO
 */
public class CopyTest {

    @Getter
    @Setter
    public static class A{
        private String name;
        private boolean sex;
        private int age;
    }

    @Getter
    @Setter
    public static class B{
        private String name;
        private Boolean sex;
        private Integer age;

        @Override
        public String toString() {
            return this.getName() + " "+ this.getAge() +" "+ this.getSex();
        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.setName("nana");
        a.setAge(5);
        a.setSex(true);

        B b = new B();
        //Integer Boolean boolean int 类型不一致 拷贝不成功
        BeanCopierUtil.copy(a,b);
        System.out.println(b);
    }

}
