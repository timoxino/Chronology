package by.chronology.web.client.service.rpc;

import by.chronology.web.client.model.UserAccount;
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
     *          object contains full user info.
     */
    void login(UserAccount userAccount, AsyncCallback<UserAccount> async);
}
