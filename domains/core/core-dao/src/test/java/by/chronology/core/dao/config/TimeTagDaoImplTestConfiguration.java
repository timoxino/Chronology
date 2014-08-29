package by.chronology.core.dao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import by.chronology.common.config.DataAccessConfiguration;

/**
 * Java-based Spring configuration for test DAO.
 *
 * @author Tsimafei_Shchytkavets
 */
@Import(DataAccessConfiguration.class)
@ComponentScan(basePackages = "by.chronology.core.dao")
@Configuration
public class TimeTagDaoImplTestConfiguration
{
}
