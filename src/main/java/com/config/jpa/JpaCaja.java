package com.config.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.respository", entityManagerFactoryRef = "GastosEntityManager", transactionManagerRef = "GastosTransactionManager")
public class JpaCaja {
    @Bean
    @Primary
    public DataSource GastosDataSource()
    {
        DriverManagerDataSource DataSource = new DriverManagerDataSource();
        DataSource.setDriverClassName("org.postgresql.Driver");
        DataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/gastos");
        DataSource.setUsername("postgres");
        DataSource.setPassword("123456");
        return DataSource;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean GastosEntityManager()
    {
        LocalContainerEntityManagerFactoryBean EntityManager = new LocalContainerEntityManagerFactoryBean();
        EntityManager.setDataSource(GastosDataSource());
        EntityManager.setPersistenceUnitName("GatosUnitName");
        EntityManager.setPackagesToScan("com.domain");
        EntityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties HibernateProperties = new Properties();
        HibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        HibernateProperties.setProperty("hibernate.show_sql", "true");
        HibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
        EntityManager.setJpaProperties(HibernateProperties);
        return EntityManager;
    }

    @Bean
    @Primary
    public PlatformTransactionManager GastosTransactionManager()
    {
        JpaTransactionManager TransactionManager = new JpaTransactionManager();
        TransactionManager.setEntityManagerFactory(GastosEntityManager().getObject());
        return TransactionManager;
    }
}
