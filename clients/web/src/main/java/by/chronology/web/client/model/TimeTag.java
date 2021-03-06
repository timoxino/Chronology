package by.chronology.web.client.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * The most base entity represents tag of the time with name and description as a string.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/9/12
 */
public class TimeTag implements Serializable
{
    private Long id;
    private String tagName;
    private String tagDescription;
    private Timestamp tagTimestamp;
    private User user;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTagName()
    {
        return tagName;
    }

    public void setTagName(String tagName)
    {
        this.tagName = tagName;
    }

    public String getTagDescription()
    {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription)
    {
        this.tagDescription = tagDescription;
    }

    public Timestamp getTagTimestamp()
    {
        return tagTimestamp;
    }

    public void setTagTimestamp(Timestamp tagTimestamp)
    {
        this.tagTimestamp = tagTimestamp;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
