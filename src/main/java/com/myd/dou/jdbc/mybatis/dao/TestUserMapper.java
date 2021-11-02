package com.myd.dou.jdbc.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import com.myd.dou.jdbc.mybatis.entity.TestUser;

import java.util.List;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/1 17:57
 * @Description:
 */
@Mapper
public interface TestUserMapper {
    int deleteByPrimaryKey(Long id);
    int insert(TestUser record);
    int insertSelective(TestUser record);
    int batchInsert(List<TestUser> records);
    TestUser selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(TestUser record);
    int updateByPrimaryKey(TestUser record);
}
