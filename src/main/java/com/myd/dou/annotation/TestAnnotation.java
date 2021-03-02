package com.myd.dou.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/12/17 11:16
 * @Description: TODO
 */
@ClassTest
public class TestAnnotation {

    @Check(value = 1)
    int a;

    @Perform(value = "xixi")
    public void mete(){

    }


    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        boolean annotationPresent = TestAnnotation.class.isAnnotationPresent(ClassTest.class);
        if(annotationPresent){
            ClassTest annotation = TestAnnotation.class.getAnnotation(ClassTest.class);
            System.out.println("id : "+annotation.id());
            System.out.println("msg : "+annotation.msg());
        }

        Field aa = TestAnnotation.class.getDeclaredField("a");
        aa.setAccessible(true);
        Check annotation = aa.getAnnotation(Check.class);
        if(null != annotation) {
            System.out.println(annotation.value());
        }

        Method mete = TestAnnotation.class.getDeclaredMethod("mete");
        if(null != mete){
            Perform annotation1 = mete.getAnnotation(Perform.class);
            if(null!= annotation1){
                System.out.println(annotation1.value());
            }


            Annotation[] annotations = mete.getAnnotations();
            if(null != annotations){
                for(Annotation an : annotations){
                    System.out.println(" method annotation name : " + an.annotationType().getName());
                }
            }
        }

    }
}
