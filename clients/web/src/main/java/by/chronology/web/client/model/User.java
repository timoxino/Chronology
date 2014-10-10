package by.chronology.web.client.model;

import java.io.Serializable;

/**
 * Entity that represents registered user and includes essential only info about him.
 *
 * @author Tsimafei_Shchytkavets
 */
public class User implements Serializable
{
    private Long id;
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
