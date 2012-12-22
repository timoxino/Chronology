package by.chronology.web.server.rpc;

import by.chronology.core.service.TimeTagBusinessService;
import by.chronology.web.client.model.TimeTag;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Tsimafei_Shchytkavets
 */
public class TimeTagServiceImplTest
{
    private TimeTagServiceImpl timeTagService;

    @Before
    public void setUp() throws Exception
    {
        // service initialization
        timeTagService = new TimeTagServiceImpl();

        // mock objects
        timeTagService.timeTagBusinessService = mock(TimeTagBusinessService.class);
        timeTagService.mapper = mock(DozerBeanMapper.class);

        // stubbing
        final ArrayList<by.chronology.core.model.TimeTag> timeTagsModel = populateTimeTagsModel();
        when(timeTagService.timeTagBusinessService.getAllTimeTags()).thenReturn(timeTagsModel);
    }

    @Test
    public void getAllTimeTags() throws Exception
    {
        // service invocation
        final List<TimeTag> timeTagsUI = timeTagService.getAllTimeTags();

        // check expectations
        verify(timeTagService.timeTagBusinessService).getAllTimeTags();
        verify(timeTagService.mapper, times(2)).map(any(by.chronology.core.model.TimeTag.class), eq(TimeTag.class));

        // check result values
        assertThat("Full list should be returned", timeTagsUI.size(), is(2));
    }

    @Test
    public void populateTimeTagsUI() throws Exception
    {
        // service invocation
        final List<TimeTag> timeTagsUI = timeTagService.populateTimeTagsUI(populateTimeTagsModel());

        // check expectations
        verify(timeTagService.mapper, times(2)).map(any(by.chronology.core.model.TimeTag.class), eq(TimeTag.class));

        // check result values
        assertThat("Full mapped list should be returned", timeTagsUI.size(), is(2));
    }

    private ArrayList<by.chronology.core.model.TimeTag> populateTimeTagsModel()
    {
        final ArrayList<by.chronology.core.model.TimeTag> timeTagsModel = new ArrayList<by.chronology.core.model.TimeTag>();
        timeTagsModel.add(createTimeTagModel(11L, "name1", "desc1"));
        timeTagsModel.add(createTimeTagModel(12L, "name2", "desc2"));
        return timeTagsModel;
    }

    private by.chronology.core.model.TimeTag createTimeTagModel(Long id, String name, String description)
    {
        by.chronology.core.model.TimeTag timeTagModel = new by.chronology.core.model.TimeTag();
        timeTagModel.setId(id);
        timeTagModel.setTagName(name);
        timeTagModel.setTagDescription(description);
        timeTagModel.setLastUpdateTimestamp(new Timestamp(123L));
        timeTagModel.setTagTimestamp(new Timestamp(234L));
        return timeTagModel;
    }
}
