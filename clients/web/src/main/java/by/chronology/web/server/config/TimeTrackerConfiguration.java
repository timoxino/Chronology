package by.chronology.web.server.config;

import java.util.Properties;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

/**
 * @author Tsimafei_Shchytkavets
 */
@PropertySource("classpath:environment.properties")
@ComponentScan(basePackages = "by.chronology")
@EnableTransactionManagement
@Configuration
public class TimeTrackerConfiguration
{
    @Bean
    public HibernateTransactionManager transactionManager(AnnotationSessionFactoryBean sessionFactory)
    {
        final HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory.getObject());
        return transactionManager;
    }

    @Bean
    public AnnotationSessionFactoryBean sessionFactory(MysqlConnectionPoolDataSource dataSource)
    {
        final AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        sessionFactoryBean.setHibernateProperties(hibernateProperties);
        sessionFactoryBean.setPackagesToScan(new String[]{"by.chronology.core.model"});
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean;
    }

    @Bean
    public MysqlConnectionPoolDataSource dataSource(
            @Value("${jdbc.test.url}") String url,
            @Value("${jdbc.test.username}") String user,
            @Value("${jdbc.test.password}") String password)
    {
        final MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setURL(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DozerBeanMapper mapper()
    {
        return new DozerBeanMapper();
    }

    @Bean
    static PropertySourcesPlaceholderConfigurer placeholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
    {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
