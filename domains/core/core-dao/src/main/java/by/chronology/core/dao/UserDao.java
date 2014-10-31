package by.chronology.core.dao;

import by.chronology.common.dao.GenericDao;
import by.chronology.core.model.User;

import java.io.Serializable;

/**
 * Interface for DAOs working with {@link by.chronology.core.model.User} entities.
 *
 * @author Tsimafei_Shchytkavets
 */
public interface UserDao extends GenericDao<User>
{
    User getById(final Serializable id);

    User update(final User entity);

    void save(final User entity);
}
