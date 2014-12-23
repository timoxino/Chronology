package by.chronology.web.client.service.rpc;

import by.chronology.web.client.model.User;
import by.chronology.web.client.model.UserAccount;
import by.chronology.web.client.model.UserContext;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * GWT client side stub for rpc service <code>UserService</code>.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/23/13
 */
public interface UserServiceAsync
{
    /**
     * Authenticates user in system.
     *
     * @param userAccount
     *          object contains necessary for login data (e.g. email and password).
     *
     * @return
     *          object contains full user info and roles.
     */
    void login(UserAccount userAccount, AsyncCallback<UserContext> async);

    /**
     * Perform update operation on {@link by.chronology.web.client.model.User} entity.
     *
     * @param user object needs to be updated
     */
    void update(User user, AsyncCallback<User> async);
}
