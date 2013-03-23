package by.chronology.web.client.common.gin.provider;

import by.chronology.web.client.service.rpc.UserService;
import by.chronology.web.client.service.rpc.UserServiceAsync;
import com.google.gwt.core.client.GWT;

/**
 * <code>UserServiceAsync</code> provider.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/23/13
 */
public class UserServiceProvider extends BaseServiceProvider<UserServiceAsync>
{
    @Override
    protected UserServiceAsync provide()
    {
        return GWT.create(UserService.class);
    }
}
