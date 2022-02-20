package com.fishingshop.configuration;


import com.fishingshop.database.IGearDAOI;
import com.fishingshop.database.IOrderDAOI;
import com.fishingshop.database.IUserDAOI;
import com.fishingshop.database.hibernate.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.fishingshop.controllers",
        "com.fishingshop.service",
        "com.fishingshop.session"
})

public class TestConfiguration {

    @Bean
    public IOrderDAOI orderDao() {
        return new OrderDaoTest();
    }

    @Bean
    public IGearDAOI gearDao() {
        return new GearDaoTest();
    }

    @Bean
    public IUserDAOI userDao() {
        return new UserDaoTest();
    }

}
