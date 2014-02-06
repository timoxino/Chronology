package by.chronology.common.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

/**
 * Java-based Spring configuration that declares all necessary beans to get access to the data from DB.
 *
 * @author Tsimafei_Shchytkavets
 */
@PropertySource("classpath:db_connection.properties")
@Import(UtilConfiguration.class)
@EnableTransactionManagement
@Configuration
public class DataAccessConfiguration
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
}
