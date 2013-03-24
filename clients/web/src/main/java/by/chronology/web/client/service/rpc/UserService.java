package by.chronology.web.client.service.rpc;

import by.chronology.web.client.model.UserAccount;
import by.chronology.web.client.model.UserContext;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Contract for servlet service that manipulates with users.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/23/13
 */
@RemoteServiceRelativePath("services/userService")
public interface UserService extends RemoteService
{
    /**
     * Authenticates user in system.
     *
     * @param userAccount
     *          object contains necessary for login data (e.g. email and password).
     * @return
     *          object contains full user info and roles.
     */
    UserContext login(UserAccount userAccount);
}
