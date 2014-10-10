package by.chronology.web.client.model;

import by.chronology.common.test.UnitTestUtils;
import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static by.chronology.common.test.UnitTestUtils.EMAIL;
import static by.chronology.common.test.UnitTestUtils.ID;
import static by.chronology.common.test.UnitTestUtils.PASSWORD;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Tsimafei_Shchytkavets
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/dozerContext-test.xml")
public class UserMappingTest
{
    @Resource
    DozerBeanMapper mapper;

    @Test
    public void convertToUI()
    {
        final by.chronology.core.model.User userModel = UnitTestUtils.createUserModel(ID, EMAIL, PASSWORD);
        final by.chronology.web.client.model.User userUI = mapper.map(userModel, by.chronology.web.client.model.User.class);
        checkUserUI(userUI);
    }

    @Test
    public void convertToModel()
    {
        final by.chronology.core.model.User userModel = mapper.map(createUser(), by.chronology.core.model.User.class);
        checkUserModel(userModel);
    }

    public static User createUser()
    {
        final User userUI = new User();
        userUI.setId(123L);
        userUI.setEmail("simple email");
        userUI.setPassword("simple password");
        return userUI;
    }

    public static void checkUserUI(User userUI)
    {
        assertThat("Invalid mapped User id", userUI.getId(), is(ID));
        assertThat("Invalid mapped User email", userUI.getEmail(), is(EMAIL));
        assertThat("Invalid mapped User password", userUI.getPassword(), is(PASSWORD));
    }

    public static void checkUserModel(by.chronology.core.model.User userModel)
    {
        assertThat("Invalid mapped User id", userModel.getId(), is(ID));
        assertThat("Invalid mapped User email", userModel.getEmail(), is(EMAIL));
        assertThat("Invalid mapped User password", userModel.getPassword(), is(PASSWORD));
    }
}
