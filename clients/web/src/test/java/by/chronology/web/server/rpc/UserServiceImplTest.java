package by.chronology.web.server.rpc;

import by.chronology.web.client.model.User;
import by.chronology.web.client.model.UserAccount;
import by.chronology.web.client.model.UserContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/23/13
 */
public class UserServiceImplTest
{
    private UserServiceImpl userService;

    @Before
    public void setUp() throws Exception
    {
        userService = new UserServiceImpl();
        userService.restTemplate = mock(RestTemplate.class);
    }

    @Test
    public void loginMock() throws Exception
    {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail("test@gmail.com");
        userAccount.setPassword("pass");

        UserContext userContext = userService.login(userAccount);
        Assert.assertNotNull(userContext.getUserAccount().getEmail());
        Assert.assertNotNull(userContext.getUserAccount().getPassword());
        Assert.assertNotNull(userContext.getUserAccount().getFirstName());
        Assert.assertNotNull(userContext.getUserAccount().getLastName());
        Assert.assertNotNull(userContext.getUserAccount().getId());
    }

    @Test
    public void update()
    {
        //given
        User user = new User();

        //when
        userService.update(user);

        //then
        verify(userService.restTemplate).postForObject("http://127.0.0.1:9090/users", user, User.class);
    }
}
