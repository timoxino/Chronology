package by.chronology.web.client.model;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static by.chronology.common.util.UnitTestUtils.ID;
import static by.chronology.common.util.UnitTestUtils.NAME;
import static by.chronology.common.util.UnitTestUtils.DESCRIPTION;
import static by.chronology.common.util.UnitTestUtils.TAG_TIMESTAMP;
import static by.chronology.common.util.UnitTestUtils.LAST_UPDATE_TIMESTAMP;

import javax.annotation.Resource;

import by.chronology.common.util.UnitTestUtils;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.chronology.core.model.TimeTag;

/**
 * @author Tsimafei_Shchytkavets
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dozerContext-test.xml")
public class TimeTagMappingTest
{
    @Resource
    DozerBeanMapper mapper;

    @Test
    public void convertToUI()
    {
        final TimeTag timeTagModel = UnitTestUtils.createTimeTagModel(ID, NAME, DESCRIPTION);
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
}
