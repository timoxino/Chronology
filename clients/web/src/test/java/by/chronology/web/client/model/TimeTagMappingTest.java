package by.chronology.web.client.model;

import by.chronology.core.model.util.CoreModelTestUtil;
import by.chronology.core.model.TimeTag;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static by.chronology.core.model.util.CoreModelTestUtil.DESCRIPTION;
import static by.chronology.core.model.util.CoreModelTestUtil.EMAIL;
import static by.chronology.core.model.util.CoreModelTestUtil.ID;
import static by.chronology.core.model.util.CoreModelTestUtil.NAME;
import static by.chronology.core.model.util.CoreModelTestUtil.PASSWORD;
import static by.chronology.core.model.util.CoreModelTestUtil.TAG_TIMESTAMP;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
        final TimeTag timeTagModel = CoreModelTestUtil.createTimeTagModel(ID, NAME, DESCRIPTION);
        timeTagModel.setUser(CoreModelTestUtil.createUserModel(ID, EMAIL, PASSWORD));
        final by.chronology.web.client.model.TimeTag timeTagUI = mapper.map(timeTagModel, by.chronology.web.client.model.TimeTag.class);
        checkTimeTagUI(timeTagUI);
    }

    @Test
    public void convertToModel()
    {
        by.chronology.web.client.model.TimeTag timeTagUI = new by.chronology.web.client.model.TimeTag();
        timeTagUI.setId(ID);
        timeTagUI.setTagName(NAME);
        timeTagUI.setTagDescription(DESCRIPTION);
        timeTagUI.setTagTimestamp(TAG_TIMESTAMP);
        timeTagUI.setUser(UserMappingTest.createUser());
        final TimeTag timeTagModel = mapper.map(timeTagUI, TimeTag.class);
        checkTimeTagModel(timeTagModel);
    }

    private void checkTimeTagUI(by.chronology.web.client.model.TimeTag timeTagUI)
    {
        assertThat("Invalid mapped id", timeTagUI.getId(), is(ID));
        assertThat("Invalid mapped name", timeTagUI.getTagName(), is(NAME));
        assertThat("Invalid mapped description", timeTagUI.getTagDescription(), is(DESCRIPTION));
        assertThat("Invalid mapped tagTimestamp", timeTagUI.getTagTimestamp(), is(TAG_TIMESTAMP));
        UserMappingTest.checkUserUI(timeTagUI.getUser());
    }

    private void checkTimeTagModel(TimeTag timeTagModel)
    {
        assertThat("Invalid mapped id", timeTagModel.getId(), is(ID));
        assertThat("Invalid mapped name", timeTagModel.getTagName(), is(NAME));
        assertThat("Invalid mapped description", timeTagModel.getTagDescription(), is(DESCRIPTION));
        assertThat("Invalid mapped tagTimestamp", timeTagModel.getTagTimestamp(), is(TAG_TIMESTAMP));
        UserMappingTest.checkUserModel(timeTagModel.getUser());
    }
}
