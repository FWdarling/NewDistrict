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
 * description: pm25Config
 * date: 4/24/21 12:04 AM
 * author: fourwood
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "pm25EntityManagerFactory",
        transactionManagerRef = "pm25TransactionManager",
        basePackages = {"com.example.demo.pm25.dao"})
public class Pm25Config {
    @Bean(name = "pm25DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.pm25")
    public DataSource pm25DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pm25EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("pm25DataSource") DataSource dataSource){
        return builder.dataSource(dataSource).packages("com.example.demo.pm25.entity").build();
    }

    @Bean(name = "pm25TransactionManager")
    public PlatformTransactionManager pm25TransactionManager(@Qualifier("pm25EntityManagerFactory") EntityManagerFactory customerEntityManagerFactory){
        return new JpaTransactionManager(customerEntityManagerFactory);
    }
}
