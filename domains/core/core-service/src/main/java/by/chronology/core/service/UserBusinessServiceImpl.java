package by.chronology.core.service;

import by.chronology.common.util.SecurityUtil;
import by.chronology.core.dao.UserDao;
import by.chronology.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * An implementation of {@link by.chronology.core.service.UserBusinessService}
 * <br> that provides functionality for saving/loading <code>User</code> from DB.
 *
 * @author Tsimafei_Shchytkavets
 */
@Service(value = "userBusinessService")
public class UserBusinessServiceImpl implements UserBusinessService
{
    @Autowired
    UserDao userDao;

    @Override
    public User createUser(User user)
    {
        final String securedPassword;
        try
        {
            securedPassword = SecurityUtil.getSHA1SecuredPassword(user.getPassword());
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
        user.setPassword(securedPassword);
        userDao.save(user);
        return user;
    }
}
