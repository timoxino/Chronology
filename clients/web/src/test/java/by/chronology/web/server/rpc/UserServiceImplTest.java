package by.chronology.web.server.rpc;

import by.chronology.web.client.model.UserAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    }

    @Test
    public void loginMock() throws Exception
    {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail("test@gmail.com");
        userAccount.setPassword("pass");

        UserAccount account = userService.login(userAccount);
        Assert.assertNotNull(account.getEmail());
        Assert.assertNotNull(account.getPassword());
        Assert.assertNotNull(account.getFirstName());
        Assert.assertNotNull(account.getLastName());
        Assert.assertNotNull(account.getId());
    }
}
