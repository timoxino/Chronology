package by.chronology.web.server.rpc;

import static by.chronology.common.util.UnitTestUtils.ID;
import static by.chronology.common.util.UnitTestUtils.NAME;
import static by.chronology.common.util.UnitTestUtils.DESCRIPTION;

import by.chronology.common.util.UnitTestUtils;
import by.chronology.core.service.TimeTagBusinessService;
import by.chronology.web.client.model.TimeTag;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

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
    private by.chronology.core.model.TimeTag timeTagModel;

    @Before
    public void setUp() throws Exception
    {
        // service initialization
        timeTagService = new TimeTagServiceImpl();
        timeTagModel = createTimeTagModel();

        // mock objects
        timeTagService.timeTagBusinessService = mock(TimeTagBusinessService.class);
        timeTagService.mapper = mock(DozerBeanMapper.class);

        // stubbing
        final ArrayList<by.chronology.core.model.TimeTag> timeTagsModel = populateTimeTagsModel();
        when(timeTagService.timeTagBusinessService.getAllTimeTags()).thenReturn(timeTagsModel);
        when(timeTagService.mapper.map(any(TimeTag.class), eq(by.chronology.core.model.TimeTag.class))).thenReturn(timeTagModel);
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

    @Test
    public void updateTimeTag()
    {
        final TimeTag timeTag = new TimeTag();

        // service invocation
        timeTagService.updateTimeTag(timeTag);

        // check expectations
        verify(timeTagService.mapper).map(timeTag, by.chronology.core.model.TimeTag.class);
        verify(timeTagService.timeTagBusinessService).createTimeTag(timeTagModel);
    }

    private by.chronology.core.model.TimeTag createTimeTagModel()
    {
        by.chronology.core.model.TimeTag timeTagModel = new by.chronology.core.model.TimeTag();
        timeTagModel.setId(ID);
        timeTagModel.setTagName(NAME);
        timeTagModel.setTagDescription(DESCRIPTION);
        return timeTagModel;
    }

    private ArrayList<by.chronology.core.model.TimeTag> populateTimeTagsModel()
    {
        final ArrayList<by.chronology.core.model.TimeTag> timeTagsModel = new ArrayList<by.chronology.core.model.TimeTag>();
        timeTagsModel.add(UnitTestUtils.createTimeTagModel(ID, NAME, DESCRIPTION));
        timeTagsModel.add(UnitTestUtils.createTimeTagModel(ID, NAME, DESCRIPTION));
        return timeTagsModel;
    }
}
