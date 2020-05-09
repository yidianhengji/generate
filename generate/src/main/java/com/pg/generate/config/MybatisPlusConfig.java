package com.pg.generate.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = {"com.pg.generate.dao"})
@EnableTransactionManagement
public class MybatisPlusConfig {
}
