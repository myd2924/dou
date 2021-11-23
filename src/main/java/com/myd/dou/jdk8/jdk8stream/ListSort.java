package com.myd.dou.jdk8.jdk8stream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/9 13:37
 * @Description: TODO
 */
public class ListSort {
    public static void main(String[] args) {
        List<StudentInfo> studentList = new ArrayList<>();
        studentList.add(new StudentInfo("李小明",true,18,1.76, LocalDate.of(2001,3,23),0));
        studentList.add(new StudentInfo("张小丽",false,18,1.61,LocalDate.of(2001,6,3),0));
        studentList.add(new StudentInfo("王大朋",true,19,1.82,LocalDate.of(2000,3,11),0));
        studentList.add(new StudentInfo("陈小跑",false,17,1.67,LocalDate.of(2002,10,18),0));
        StudentInfo.printStudents(studentList);
        final List<StudentInfo> collect = studentList.stream()
                .sorted(Comparator.comparing(StudentInfo::getAge).reversed())
                .collect(Collectors.toList());
        final List<StudentInfo> result = studentList.stream()
                .filter(re->re.getAge()>18)
                .collect(Collectors.toList());


        StudentInfo.printStudents(studentList);
        StudentInfo.printStudents(result);
    }
}
