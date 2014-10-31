package by.chronology.core.dao;

import by.chronology.common.dao.impl.GenericDaoImpl;
import by.chronology.core.model.User;

/**
 * An implementation of {@link by.chronology.core.dao.UserDao} interface.
 *
 * @author Tsimafei_Shchytkavets
 */
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao
{
    /**
     * Instantiate DAO based on <code>class</code>.
     */
    public UserDaoImpl()
    {
        super(User.class);
    }
}
