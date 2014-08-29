package by.chronology.core.service;

import by.chronology.common.dao.criteria.DateRangeSearchCriteria;
import by.chronology.core.dao.TimeTagDao;
import by.chronology.core.model.TimeTag;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/4/12
 */
public class TimeTagBusinessServiceImplTest
{
    private TimeTagBusinessServiceImpl timeTagBusinessService;
    private List<TimeTag> timeTagsFromDao;

    @Before
    public void setUp() throws Exception
    {
        // service initialization
        timeTagBusinessService = new TimeTagBusinessServiceImpl();

        // mock objects
        timeTagBusinessService.timeTagDao = mock(TimeTagDao.class);

        // stubbing
        timeTagsFromDao = Arrays.asList(new TimeTag());
        when(timeTagBusinessService.timeTagDao.getAll()).thenReturn(timeTagsFromDao);
    }

    @Test
    public void createTimeTag()
    {
        final TimeTag timeTag = new TimeTag();

        // target service invocation
        final TimeTag result = timeTagBusinessService.createTimeTag(timeTag);

        // check expectations
        verify(timeTagBusinessService.timeTagDao).save(timeTag);

        // check result values
        assertThat("Service should return all objects provided by DAO", result, is(timeTag));
    }

    @Test
    public void getTimeTags()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 8, 29);
        final Date date1 = new Date(calendar.getTimeInMillis());
        calendar.set(2014, 8, 31);
        final Date date2 = new Date(calendar.getTimeInMillis());

        // target service invocation
        timeTagBusinessService.getTimeTags(date1, date2);

        // check expectations
        final ArgumentCaptor<DateRangeSearchCriteria> argumentCaptor = ArgumentCaptor.forClass(DateRangeSearchCriteria.class);
        verify(timeTagBusinessService.timeTagDao).getByDates(argumentCaptor.capture());

        final Date startDate = argumentCaptor.getValue().getStartDate();
        final Date endDate = argumentCaptor.getValue().getEndDate();

        // check result values
        assertThat("Unexpected start date object in criteria", startDate, sameInstance(date1));
        assertThat("Unexpected end date object in criteria", endDate, sameInstance(date2));
    }

    @Test
    public void deleteTimeTag()
    {
        // target service invocation
        timeTagBusinessService.deleteTimeTag(123L);

        // check expectations
        verify(timeTagBusinessService.timeTagDao).deleteById(123L);
    }
}
