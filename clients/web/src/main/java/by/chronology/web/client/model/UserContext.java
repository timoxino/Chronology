package by.chronology.web.client.model;

import java.io.Serializable;
import java.util.List;

/**
 * Represents context of logged user.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/24/13
 */
public class UserContext implements Serializable
{
    private UserAccount userAccount;
    private List<Role> roles;

    public UserAccount getUserAccount()
    {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount)
    {
        this.userAccount = userAccount;
    }

    public List<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }
}
