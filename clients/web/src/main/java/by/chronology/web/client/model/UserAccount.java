package by.chronology.web.client.model;

import java.io.Serializable;

/**
 * Contains registered user-related information.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/23/13
 */
public class UserAccount implements Serializable
{
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
