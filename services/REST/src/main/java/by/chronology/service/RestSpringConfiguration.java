package by.chronology.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * Java-based Spring configuration.
 *
 * @author Tsimafei_Shchytkavets
 */
@ComponentScan(basePackages = "by.chronology")
@PropertySource("classpath:environment.properties")
@Configuration
public class RestSpringConfiguration extends WebMvcConfigurationSupport
{
    @Bean
    public EmbeddedServletContainerFactory servletContainer(@Value("${tomcat.port}") String port)
    {
        return new TomcatEmbeddedServletContainerFactory(Integer.valueOf(port));
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter handlerAdapter = super.requestMappingHandlerAdapter();
        handlerAdapter.getMessageConverters().add(0, jackson2HttpMessageConverter());
        return handlerAdapter;
    }

    @Bean
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter()
    {
        return new MappingJackson2HttpMessageConverter();
    }

    @Bean
    static PropertySourcesPlaceholderConfigurer placeholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
