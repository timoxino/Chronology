package by.chronology.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity that represents registered user and includes essential only info about him.
 *
 * @author Tsimafei_Shchytkavets
 */
@Entity
@Table(name = "USER", schema = "TIME")
public class User
{
    private Long id;
    private String email;
    private String password;
    private String salt;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_KEY", unique = true, nullable = false)
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Column(name = "EMAIL", nullable = false)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Column(name = "PASSWORD", nullable = false)
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Column(name = "SALT")
    public String getSalt()
    {
        return salt;
    }

    public void setSalt(String salt)
    {
        this.salt = salt;
    }
}
