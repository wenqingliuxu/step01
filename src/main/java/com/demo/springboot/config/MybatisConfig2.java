package com.demo.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.demo.springboot.*.dao2",sqlSessionFactoryRef = "sqlSessionFactory2")
public class MybatisConfig2 {

  @Resource(name="dataSource2")
  private DataSource dataSource1;


  @Bean("sqlSessionFactory2")
  public SqlSessionFactory getSqlSessionFactory() throws  Exception{
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(dataSource1); // 使用dataSource1数据源
    factoryBean.setMapperLocations(new    PathMatchingResourcePatternResolver().getResources("classpath:mapper2/*.xml"));
    return factoryBean.getObject();
  }

  @Bean("dataSourceTransactionManager2")
  public DataSourceTransactionManager getDataSourceTransactionManager(){
    DataSourceTransactionManager  dataSourceTransactionManager=new DataSourceTransactionManager();
    dataSourceTransactionManager.setDataSource(dataSource1);
    return  dataSourceTransactionManager;
  }
}
