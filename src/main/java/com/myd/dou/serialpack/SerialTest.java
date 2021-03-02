package com.myd.dou.serialpack;

import com.myd.dou.dto.Student;

import java.io.*;

/**
 * @ClassName SerialTest
 * @Description TODO
 * @Author 18050909
 * @Date 2020/5/14 11:53
 * @Version 1.0
 **/
public class SerialTest {
    public static void main(String[] args) throws IOException {
        //序列化
        FileOutputStream fos = new FileOutputStream("object.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Student student1 = new Student("lihao", "wjwlh", 21);
        oos.writeObject(student1);
        oos.flush();
        oos.close();
        //反序列化
        FileInputStream fis = new FileInputStream("object.out");
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            Student student2 = (Student) ois.readObject();
            System.out.println(student2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
