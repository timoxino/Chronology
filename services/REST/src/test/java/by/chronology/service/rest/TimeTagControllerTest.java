package by.chronology.service.rest;

import by.chronology.common.test.UnitTestUtils;
import by.chronology.core.model.TimeTag;
import by.chronology.core.service.TimeTagBusinessService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Tsimafei_Shchytkavets
 */
public class TimeTagControllerTest
{
    private TimeTagController controller;

    @Before
    public void setUp()
    {
        controller = new TimeTagController();
        controller.timeTagBusinessService = mock(TimeTagBusinessService.class);
    }

    @Test
    public void createTimeTag()
    {
        //given
        final TimeTag newTimeTag = UnitTestUtils.createTimeTagModel(null, "testName", "testDesc");
        final TimeTag savedTimeTag = UnitTestUtils.createTimeTagModel(123L, "testName", "testDesc");
        when(controller.timeTagBusinessService.createTimeTag(newTimeTag)).thenReturn(savedTimeTag);

        //when
        final TimeTag createdTimeTag = controller.createTimeTag(newTimeTag);
        
        //then
        verify(controller.timeTagBusinessService).createTimeTag(newTimeTag);
        assertThat("Invalid value of id", createdTimeTag.getId(), is(123L));
        assertThat("Invalid value of name", createdTimeTag.getTagName(), is("testName"));
        assertThat("Invalid value of description", createdTimeTag.getTagDescription(), is("testDesc"));
    }
}
