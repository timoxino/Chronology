package by.chronology.web.server.rpc;

import by.chronology.web.client.model.UserAccount;
import by.chronology.web.client.model.UserContext;
import by.chronology.web.client.service.rpc.UserService;
import by.chronology.web.server.common.RemoteServiceSpringSupportServlet;

/**
 * Servlet for GWT client that provides functionality related to users.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/23/13
 */
public class UserServiceImpl extends RemoteServiceSpringSupportServlet implements UserService
{
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
}
