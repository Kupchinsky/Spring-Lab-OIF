package ru.kuzstu.openinfsystems.spring;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class AppConfiguration {

    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
        return hibernateTransactionManager;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        System.setProperty("org.jboss.logging.provider", "slf4j");

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        Properties hibernateProperties;
        try {
            hibernateProperties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("hibernate.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Unable to load Hibernate properties", e);
        }

        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        localSessionFactoryBean.setPackagesToScan("ru.kuzstu.openinfsystems.spring.model");
        localSessionFactoryBean.setDataSource(dataSource());

        return localSessionFactoryBean;
    }

    HikariDataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    HikariConfig hikariConfig() {
        final Properties hikariProperties;

        try {
            hikariProperties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("hikari.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Unable to load Hikari properties", e);
        }

        return new HikariConfig(hikariProperties);
    }
}
