package com.myd.dou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="mailto:mayuanding@qianmi.com">OF3787-马元丁</a>
 * @version 0.1.0
 * @Date:2020/12/3 16:02
 * @Description: 配置类测试
 */
@Configuration
public class MyTestConfig {

    @Bean
    public Driver driver(){
        Driver driver = new Driver();
        driver.setId("1");
        driver.setName("driver");
        driver.setCar(car());
        return driver;
    }

    @Bean
    public Car car(){
        Car car = new Car();
        car.setId("1");
        car.setName("car");
        return car;
    }
}
