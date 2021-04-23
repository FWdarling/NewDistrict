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
 * description: ClimateConfig
 * date: 4/24/21 12:05 AM
 * author: fourwood
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "climateEntityManagerFactory",
        transactionManagerRef = "climateTransactionManager",
        basePackages = {"com.example.demo.climate.dao"})
public class ClimateConfig {
    @Bean(name = "climateDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.climate")
    public DataSource climateDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "climateEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("climateDataSource") DataSource dataSource){
        return builder.dataSource(dataSource).packages("com.example.demo.climate.entity").build();
    }

    @Bean(name = "climateTransactionManager")
    public PlatformTransactionManager climateTransactionManager(@Qualifier("climateEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory){
        return new JpaTransactionManager(customerEntityManagerFactory);
    }
}
