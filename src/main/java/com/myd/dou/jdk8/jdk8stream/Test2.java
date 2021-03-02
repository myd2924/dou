package com.myd.dou.jdk8.jdk8stream;

import com.myd.dou.dto.User;
import com.myd.dou.util.BatchHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/1/8 09:33
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        User user1 = User.builder().id("1").name("羊豆").age(5).build();
        User user2 = User.builder().id("2").name("糖豆").age(3).build();
        User user3 = User.builder().id("3").name("爸爸").age(32).build();
        User user4 = User.builder().id("4").name("妈妈").age(30).build();
        List list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        new BatchHelper<User>(list,2) {
            @Override
            public void eachBatch(List<User> eachList) {
                System.out.println(eachList);
                try {
                    System.out.println("休息两秒");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.executeBatch();



    }
}
