package com.demo.springboot.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration

/*扫描业务模块中的@Service、@Controller、@Reposistory、@Component*/
@ComponentScan(basePackages = "com.demo.springboot")

@PropertySource(value = "classpath:config.properties")
public class RooConfig {
  private static final Logger logger = LogManager.getLogger(RooConfig.class);

  @Value("${jdbc1.driverClassName}")
  private String className;

  @Value("${jdbc1.url}")
  private String url;

  @Value("${jdbc1.username}")
  private String userName;

  @Value("${jdbc1.password}")
  private String password;

  /*相当于：<bean id="object>*/
  //@Bean
  public DataSource dataSource() {
    logger.info("this.className:"+this.className);
    DriverManagerDataSource dataSource=new DriverManagerDataSource();
    dataSource.setDriverClassName(this.className);
    dataSource.setUrl(this.url);
    dataSource.setUsername(this.userName);
    dataSource.setPassword(this.password);
    return dataSource;
  }

  @Bean("dataSource1")
  @ConfigurationProperties(prefix="jdbc1")
  @Primary
  public DriverManagerDataSource  dataSource1(){
    logger.info("dataSource2....");
    DriverManagerDataSource dataSource=new DriverManagerDataSource();
    return dataSource;
  }


  @Bean("dataSource2")
  @ConfigurationProperties(prefix="jdbc2")
  public DriverManagerDataSource  dataSource2(){
    logger.info("dataSource2....");
    DriverManagerDataSource dataSource=new DriverManagerDataSource();
    return dataSource;
  }
}
