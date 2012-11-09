package by.chronology.common.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Generic Data Access Object.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 11/4/12
 */
public class GenericDaoImpl<T>
{
    @Resource
    protected SessionFactory sessionFactory;
    protected Class<T> c1ass;

    /**
     * Instantiate DAO based on <code>class</code>.
     *
     * @param c1ass
     *      Class will be used by DAO
     */
    public GenericDaoImpl(Class<T> c1ass)
    {
        this.c1ass = c1ass;
    }

    /**
     * Returns instance of current hibernate session.
     *
     * @return
     *      current hibernate session
     */
    public Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    /**
     * Returns entity by <code>id</code>.
     *
     * @param id
     *      entity id
     * @return
     *      entity
     */
    public T getById(final Serializable id)
    {
        Assert.notNull(id, "ID must not be null");
        return (T) getCurrentSession().get(c1ass, id);
    }

    /**
     * Returns all entities of this <code>c1ass</code>.
     *
     * @return
     *      list of all available entities
     */
    public List<T> getAll()
    {
        return getCurrentSession().createCriteria(c1ass).list();
    }

    /**
     * Updates <code>entity</code>.
     *
     * @param entity
     *      entity to be updated
     *
     * @return
     *      updated entity
     */
    public T update(final T entity)
    {
        Assert.notNull(entity, "Entity to update must not be null");
        return (T) getCurrentSession().merge(entity);
    }

    /**
     * Persists <code>entity</code>.
     *
     * @param entity
     *      entity to be persisted
     */
    public void save(final T entity)
    {
        Assert.notNull(entity, "Entity to save must not be null");
        getCurrentSession().persist(entity);
    }

    /**
     * Persists or updates <code>entity</code>.
     *
     * @param entity
     *      entity to be saved or updated
     */
    public void saveOrUpdate(final T entity)
    {
        Assert.notNull(entity, "Entity to save or update must not be null");
        getCurrentSession().saveOrUpdate(entity);
    }

    /**
     * Deletes <code>entity</code>.
     *
     * @param entity
     *      entity to be deleted
     *
     */
    public void delete(final T entity)
    {
        Assert.notNull(entity, "Entity to delete must not be null");
        getCurrentSession().delete(entity);
    }

    /**
     * Deletes entity by <code>id</code>.
     *
     * @param id
     *      id of entity to be deleted
     */
    public void deleteById(final Serializable id)
    {
        Assert.notNull(id, "ID must not be null");
        delete(getById(id));
    }
}
