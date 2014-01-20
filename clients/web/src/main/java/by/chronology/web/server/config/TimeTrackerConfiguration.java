package by.chronology.web.server.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import by.chronology.common.config.DataAccessConfiguration;

/**
 * Java-based Spring configuration that declares all necessary beans for TimeTracker web application.
 *
 * @author Tsimafei_Shchytkavets
 */
@Import(DataAccessConfiguration.class)
@ComponentScan(basePackages = "by.chronology")
@Configuration
public class TimeTrackerConfiguration
{
    @Bean
    public DozerBeanMapper mapper()
    {
        return new DozerBeanMapper();
    }
}
