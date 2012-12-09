package by.chronology.web.client.common.gin.provider;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/9/12
 */
public class BaseServiceProviderTest
{
    private BaseServiceProvider baseServiceProvider;

    @Before
    public void setUp() throws Exception
    {
        baseServiceProvider = new BaseServiceProvider()
        {
            @Override
            protected Object provide()
            {
                return new Object();
            }
        };
    }

    @Test
    public void calculateServiceUrl() throws Exception
    {
        final String actual = baseServiceProvider.calculateServiceUrl("http://localhost:8080/by.chronology.web.TimeTracker/", "http://localhost:8080/by.chronology.web.TimeTracker/services/timeTagService");
        assertThat("Incorrect path calculated", actual, is("http://localhost:8080/services/timeTagService"));
    }
}
