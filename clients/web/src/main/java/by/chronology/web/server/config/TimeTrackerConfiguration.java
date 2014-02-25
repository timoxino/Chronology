package by.chronology.web.server.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Java-based Spring configuration that declares all necessary beans for TimeTracker web application.
 *
 * @author Tsimafei_Shchytkavets
 */
@ComponentScan(basePackages = "by.chronology.web")
@Configuration
public class TimeTrackerConfiguration
{
    @Bean
    public DozerBeanMapper mapper()
    {
        return new DozerBeanMapper();
    }

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
