package by.chronology.core.config;

import by.chronology.common.config.DataAccessConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Java-based Spring configuration for testing core model.
 *
 * @author Tsimafei_Shchytkavets
 */
@Import(DataAccessConfiguration.class)
@ComponentScan(basePackages = "by.chronology.core.model")
@Configuration
public class CoreModelMappingTestConfiguration
{
}
