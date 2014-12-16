package by.chronology.core.service;

import by.chronology.core.model.User;

/**
 * Contract for services that manipulate with {@link by.chronology.core.model.User} entities.
 *
 * @author Tsimafei_Shchytkavets
 */
public interface UserBusinessService
{
    /**
     * Create new <code>User</code> entity and store it in database.
     *
     * @param user entity need to be saved
     * @return stored entity
     */
    User createUser(User user);
}
