package by.chronology.core.service;

import by.chronology.core.dao.TimeTagDao;
import by.chronology.core.model.TimeTag;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/4/12
 */
public class TimeTagServiceImplTest
{
    private TimeTagServiceImpl timeTagService;
    private List<TimeTag> timeTagsFromDao;

    @Before
    public void setUp() throws Exception
    {
        // service initialization
        timeTagService = new TimeTagServiceImpl();

        // mock objects
        timeTagService.timeTagDao = mock(TimeTagDao.class);

        // stubbing
        timeTagsFromDao = Arrays.asList(new TimeTag());
        when(timeTagService.timeTagDao.getAll()).thenReturn(timeTagsFromDao);
    }

    @Test
    public void getAllTimeTags() throws Exception
    {
        // target service invocation
        List<TimeTag> timeTags = timeTagService.getAllTimeTags();

        // check expectations
        verify(timeTagService.timeTagDao).getAll();

        // check result values
        Assert.assertThat("Service should return all objects provided by DAO", timeTags, is(timeTagsFromDao));
    }
}
