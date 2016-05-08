package com.ssh1.config;

import com.ssh1.dao.UserDao;
import com.ssh1.dao.UserDaoImpl;
import com.ssh1.model.User;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by fishzhe on 5/7/16.
 */
@Configuration
@ComponentScan(basePackages = {"com.ssh1"})
@EnableTransactionManagement
@PropertySource("classpath:/persistence-mysql.properties")
public class PersistenceConfig {

    @Autowired
    private Environment env;

    @Bean
    protected Properties hibernateProperites() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.globally_quoted_identifiers", "true");
        return properties;
    }

    @Bean
    protected DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setHibernateProperties(hibernateProperites());
        sessionFactory.setAnnotatedClasses(User.class);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
        hibernateTransactionManager.setDataSource(dataSource());
        return hibernateTransactionManager;
    }
    @Bean
    @Autowired
    public UserDao userDao(SessionFactory sessionFactory) {
        UserDaoImpl userDao = new UserDaoImpl();
        userDao.setSessionFactory(sessionFactory);
        return userDao;
    }
}
