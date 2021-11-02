package com.myd.dou.jdbc;

import com.myd.dou.jdk8.jdk8stream.PartitionUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.Objects;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2021/11/1 16:44
 * @Description:
 */
@Slf4j
public class JDBCTest {
    private static final String URL = "jdbc:mysql://localhost:3306/myd?useUnicode=true";
    private static final String USER_NAME = "root";
    private static final String PASS_WORD = "myd123456";

    public static void main(String[] args) {
        ResultSet resultSet = null;
        Connection connection = null;
        try{
            //1加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2获取链接
            connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
            //创建sql
            final String sql = "select * from t_student";
            final Statement statement = connection.createStatement();
            //4执行sql
            resultSet = statement.executeQuery(sql);
            //5处理结果
            while(resultSet.next()){
                log.info("resultSet="+resultSet.getString(2));
            }

        } catch (Exception e){
            System.out.println(e);
        } finally {
            //6关闭链接
            try {
                if(Objects.nonNull(resultSet)){
                    resultSet.close();
                }
                if(Objects.nonNull(connection)){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
