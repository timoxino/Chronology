package by.chronology.web.client.model;

import java.io.Serializable;
import java.util.List;

/**
 * Keeps user's role.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/24/13
 */
public class Role implements Serializable
{
    private String name;
    private List<String> permissions;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<String> getPermissions()
    {
        return permissions;
    }

    public void setPermissions(List<String> permissions)
    {
        this.permissions = permissions;
    }
}
