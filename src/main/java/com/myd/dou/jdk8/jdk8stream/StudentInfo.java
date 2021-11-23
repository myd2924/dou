package com.myd.dou.jdk8.jdk8stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/9 13:38
 * @Description:
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
public class StudentInfo implements Comparable<StudentInfo> {
    //名称
    private String name;

    //性别 true男 false女
    private Boolean gender;

    //年龄
    private Integer age;

    //身高
    private Double height;

    //出生日期
    private LocalDate birthday;

    private Integer sort;

    @Override
    public int compareTo(StudentInfo o) {
        return this.age.compareTo(o.getAge());
    }


    public static void printStudents(List<StudentInfo> studentInfos){
        System.out.println("[姓名]\t\t[性别]\t\t[年龄]\t\t[身高]\t\t[生日]");
        System.out.println("----------------------------------------------------------");
        studentInfos.forEach(s->System.out.println(s.toString()));
        System.out.println(" ");
    }

}
