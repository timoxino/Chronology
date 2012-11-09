package by.chronology.common.dao;

import org.hibernate.Session;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;

/**
 * Contract for generic DAOs.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 11/9/12
 */
public interface GenericDao<T>
{
    /**
     * Returns instance of current hibernate session.
     *
     * @return
     *      current hibernate session
     */
    Session getCurrentSession();

    /**
     * Returns entity by <code>id</code>.
     *
     * @param id
     *      entity id
     * @return
     *      entity
     */
    T getById(final Serializable id);

    /**
     * Returns all entities of this <code>c1ass</code>.
     *
     * @return
     *      list of all available entities
     */
    List<T> getAll();

    /**
     * Updates <code>entity</code>.
     *
     * @param entity
     *      entity to be updated
     *
     * @return
     *      updated entity
     */
    T update(final T entity);

    /**
     * Persists <code>entity</code>.
     *
     * @param entity
     *      entity to be persisted
     */
    void save(final T entity);

    /**
     * Persists or updates <code>entity</code>.
     *
     * @param entity
     *      entity to be saved or updated
     */
    void saveOrUpdate(final T entity);

    /**
     * Deletes <code>entity</code>.
     *
     * @param entity
     *      entity to be deleted
     *
     */
    void delete(final T entity);

    /**
     * Deletes entity by <code>id</code>.
     *
     * @param id
     *      id of entity to be deleted
     */
    void deleteById(final Serializable id);
}
