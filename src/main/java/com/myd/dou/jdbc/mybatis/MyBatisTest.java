package com.myd.dou.jdbc.mybatis;

import com.alibaba.fastjson.JSON;
import com.myd.dou.jdbc.mybatis.dao.TestUserMapper;
import com.myd.dou.jdbc.mybatis.entity.TestUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/1 17:43
 * @Description:
 */
@Slf4j
public class MyBatisTest {
    public static void main(String[] args) {
        try {
            //1读取配置
            final InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //2创建sqlSessionFactory工厂
            final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //3获取sqlSession
            final SqlSession sqlSession = sqlSessionFactory.openSession();
            //4获取mapper
            final TestUserMapper mapper = sqlSession.getMapper(TestUserMapper.class);
            //5执行接口方法
            /*mapper.insert(TestUser.builder()
                    .nickname("大曦")
                    .realName("大豆")
                    .dateCreate(new Date())
                    .dateUpdate(new Date())
                    .deleted(0L)
                    .memberId(15L)
                    .build());*/
            final TestUser testUser = mapper.selectByPrimaryKey(42013L);
            log.info("testUser="+ JSON.toJSONString(testUser));
            //6提交事务
            sqlSession.commit();
            //7关闭资源
            sqlSession.close();
            inputStream.close();
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
    }
}