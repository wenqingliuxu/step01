package com.demo.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.demo.springboot.*.dao1",sqlSessionFactoryRef = "sqlSessionFactory1")
public class MybatisConfig1 {

  @Resource(name="dataSource1")
  private DataSource dataSource1;

  @Primary
  @Bean("sqlSessionFactory1")
  public SqlSessionFactory getSqlSessionFactory() throws  Exception{
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource1); // 使用dataSource1数据源
    factoryBean.setMapperLocations(new    PathMatchingResourcePatternResolver().getResources("classpath:mapper1/*.xml"));
    return factoryBean.getObject();
  }

  @Primary
  @Bean("dataSourceTransactionManager1")
  public DataSourceTransactionManager getDataSourceTransactionManager(){
    DataSourceTransactionManager  dataSourceTransactionManager=new DataSourceTransactionManager();
    dataSourceTransactionManager.setDataSource(dataSource1);
    return  dataSourceTransactionManager;
  }
}
