package by.chronology.web.server.rpc;

import by.chronology.web.client.model.User;
import by.chronology.web.client.model.UserAccount;
import by.chronology.web.client.model.UserContext;
import by.chronology.web.client.service.rpc.UserService;
import by.chronology.web.server.common.RemoteServiceSpringSupportServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Servlet for GWT client that provides functionality related to users.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/23/13
 */
public class UserServiceImpl extends RemoteServiceSpringSupportServlet implements UserService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    RestTemplate restTemplate;

    @Override
    public UserContext login(UserAccount userAccount)
    {
        // TODO: replace with real login service implementation.
        UserAccount account = new UserAccount();
        account.setEmail(userAccount.getEmail());
        account.setPassword(userAccount.getPassword());
        account.setFirstName("Tsimafei");
        account.setLastName("Shchytkavets");
        account.setId(1234567L);

        UserContext userContext = new UserContext();
        userContext.setUserAccount(account);

        return userContext;
    }

    @Override
    public User update(User user)
    {
        LOGGER.debug("User update servlet operation has been started...");

        if (user.getId() == null)
        {
            return restTemplate.postForObject("http://127.0.0.1:9090/users", user, User.class);
        }
        else
        {
            // TODO: update functionality will be implemented later
            return null;
        }
    }
}
