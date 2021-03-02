package com.myd.dou.jdk8.interfac;

/**
 * @Classname FormuaImpl
 * @Description TODO
 * @Date 2020/7/23 10:53
 * @Created by mayd
 */
public class FormuaImpl implements Formua {
    @Override
    public double calculate(int a) {
        return sqrt(a*100);
    }

}
