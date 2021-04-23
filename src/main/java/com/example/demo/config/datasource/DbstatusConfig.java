package com.example.demo.config.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * description: DbstatusConfig
 * date: 4/23/21 11:39 PM
 * author: fourwood
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "dbstatusEntityManagerFactory",
        transactionManagerRef = "dbstatusTransactionManager",
        basePackages = {"com.example.demo.dbstatus.dao"})
public class DbstatusConfig {

    @Primary
    @Bean(name = "dbstatusDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dbstatus")
    public DataSource dbstatusDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "dbstatusEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dbstatusDataSource") DataSource dataSource){
        return builder.dataSource(dataSource).packages("com.example.demo.dbstatus.entity").build();
    }

    @Primary
    @Bean(name = "dbstatusTransactionManager")
    public PlatformTransactionManager dbstatusTransactionManager(@Qualifier("dbstatusEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory){
        return new JpaTransactionManager(customerEntityManagerFactory);
    }
}
