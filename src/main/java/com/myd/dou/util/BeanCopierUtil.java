package com.myd.dou.util;

import com.myd.dou.dto.Student;
import com.myd.dou.dto.User;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/24 14:52
 * @Description: TODO
 */
@Slf4j
public class BeanCopierUtil {
    public static void copy(Object from,Object to){
        final BeanCopier beanCopier = BeanCopier.create(from.getClass(), to.getClass(), false);
        beanCopier.copy(from,to,null);
    }

    public static <T> T copy(Object from, Supplier<T> to, Class<T> clazz){
        final BeanCopier beanCopier = BeanCopier.create(from.getClass(), clazz, false);
        T t = to.get();
        beanCopier.copy(from,t,null);
        return t;
    }

    /**
     * 集合拷贝
     * @param sources
     * @param target
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S,T> List<T> copyList(List<S> sources, Supplier<T> target){
        return copyList(sources,target,null);
    }

    /**
     * 几个拷贝+自定义
     * @param sources
     * @param target
     * @param callBack
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> copyList(List<S> sources, Supplier<T> target, BeanCopierCallBack<S,T> callBack) {
        if(CollectionUtils.isEmpty(sources)){
            return new ArrayList<>();
        }
        List<T> result = new ArrayList<>(sources.size());
        for(S s:sources){
            T t = target.get();
            copy(s,t);
            result.add(t);
            if(null != callBack){
                callBack.callback(s,t);
            }
        }
        return result;
    }


    @Test
    public void listCopyUpWithCallback() {
        List<Student> userDOList = new ArrayList();
        userDOList.add(new Student("大曦", "南京", 5, "画画"));
        userDOList.add(new Student("二曦", "南京", 4, "跳舞"));
        List<User> userVOList = BeanCopierUtil.copyList(userDOList, User::new, (student, user) ->{
            // 这里可以定义特定的转换规则
            user.setId(student.getHobby());
            user.setAge(student.getAge()+100);
        });
        log.info("userList:{}",userVOList);
    }


}
