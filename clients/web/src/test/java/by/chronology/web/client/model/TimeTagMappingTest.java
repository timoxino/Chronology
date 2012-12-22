package by.chronology.web.client.model;

import by.chronology.core.model.*;
import by.chronology.core.model.TimeTag;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.notNull;

/**
 * @author Tsimafei_Shchytkavets
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dozerContext-test.xml")
public class TimeTagMappingTest
{
    private static final Long ID = 123L;
    private static final String NAME = "name1";
    private static final String DESCRIPTION = "name1";
    private static final Timestamp LAST_UPDATE_TIMESTAMP = new Timestamp(123L);
    private static final Timestamp TAG_TIMESTAMP = new Timestamp(234L);

    @Resource
    DozerBeanMapper mapper;

    @Test
    public void convertToUI()
    {
        final TimeTag timeTagModel = createTimeTagModel(ID, NAME, DESCRIPTION);
        final by.chronology.web.client.model.TimeTag timeTagUI = mapper.map(timeTagModel, by.chronology.web.client.model.TimeTag.class);
        checkTimeTagUI(timeTagUI);
    }

    private void checkTimeTagUI(by.chronology.web.client.model.TimeTag timeTagUI)
    {
        assertThat("Invalid mapped id", timeTagUI.getId(), is(ID));
        assertThat("Invalid mapped name", timeTagUI.getTagName(), is(NAME));
        assertThat("Invalid mapped description", timeTagUI.getTagDescription(), is(DESCRIPTION));
        assertThat("Invalid mapped tagTimestamp", timeTagUI.getTagTimestamp(), is(TAG_TIMESTAMP));
        assertThat("Invalid mapped lastUpdateTimestamp", timeTagUI.getLastUpdateTimestamp(), is(LAST_UPDATE_TIMESTAMP));
    }

    private by.chronology.core.model.TimeTag createTimeTagModel(Long id, String name, String description)
    {
        by.chronology.core.model.TimeTag timeTagModel = new by.chronology.core.model.TimeTag();
        timeTagModel.setId(id);
        timeTagModel.setTagName(name);
        timeTagModel.setTagDescription(description);
        timeTagModel.setLastUpdateTimestamp(LAST_UPDATE_TIMESTAMP);
        timeTagModel.setTagTimestamp(TAG_TIMESTAMP);
        return timeTagModel;
    }
}
