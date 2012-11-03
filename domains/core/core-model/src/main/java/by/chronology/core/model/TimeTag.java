package by.chronology.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.sql.Timestamp;

/**
 * The most base entity represents tag of the time with name and description as a string.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 11/3/12
 */
@Entity
@Table(name = "TIME_TAG", schema = "TIME")
public class TimeTag
{
    private Timestamp lastUpdateTimestamp;
    private Long id;
    private String tagName;
    private String tagDescription;
    private Timestamp tagTimestamp;

    @Version
    @Column(name = "LST_UPDT_TS", nullable = false)
    public Timestamp getLastUpdateTimestamp()
    {
        return lastUpdateTimestamp;
    }

    public void setLastUpdateTimestamp(Timestamp lastUpdateTimestamp)
    {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TIME_TAG_KEY", unique = true, nullable = false)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Column(name = "TIME_TAG_NAME", nullable = false)
    public String getTagName()
    {
        return tagName;
    }

    public void setTagName(String tagName)
    {
        this.tagName = tagName;
    }

    @Column(name = "TIME_TAG_DESC", nullable = true)
    public String getTagDescription()
    {
        return tagDescription;
    }

    public void setTagDescription(String tagDescription)
    {
        this.tagDescription = tagDescription;
    }

    @Column(name = "TIME_TAG_TS", nullable = false)
    public Timestamp getTagTimestamp()
    {
        return tagTimestamp;
    }

    public void setTagTimestamp(Timestamp tagTimestamp)
    {
        this.tagTimestamp = tagTimestamp;
    }
}
