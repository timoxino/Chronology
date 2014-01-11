package by.chronology.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Java-based Spring configuration.
 *
 * @author Tsimafei_Shchytkavets
 */
@PropertySource("classpath:environment.properties")
@Configuration
public class RestSpringConfiguration
{
    @Bean
    public EmbeddedServletContainerFactory servletContainer(@Value("${tomcat.port}") String port) {
        final TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(Integer.valueOf(port));
        return factory;
    }
}
