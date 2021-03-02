package com.myd.dou.javabase;

import com.myd.dou.dto.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @ClassName TestTransient
 * @Description TODO
 * @Author 18050909
 * @Date 2020/4/26 11:43
 * @Version 1.0
 **/
public class TestTransient {
    public static void main(String[] args) {

    }
    //序列化
    public static void SerializeUser() throws IOException {
        User user = new User();
        user.setName("daxi");
        user.setAge(4);

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("F://test/template"));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != oos){
                oos.close();
            }
        }

    }
    //反序列化

}
