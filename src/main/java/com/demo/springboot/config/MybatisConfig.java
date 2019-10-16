package com.demo.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.demo.springboot.*.dao")
public class MybatisConfig {
}
