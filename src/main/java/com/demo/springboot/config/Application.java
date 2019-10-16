package com.demo.springboot.config;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 */
@EnableAutoConfiguration(exclude={MybatisAutoConfiguration.class})

@ComponentScan
/*相当于以上两个注解，加上@Configuration*/
//@SpringBootApplication
public class Application {

  /*应用启动方法*/
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
