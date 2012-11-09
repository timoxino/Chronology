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
public class GenericDaoImpl<T> implements  GenericDao<T>
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

    @Override
    public Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public T getById(final Serializable id)
    {
        Assert.notNull(id, "ID must not be null");
        return (T) getCurrentSession().get(c1ass, id);
    }

    @Override
    public List<T> getAll()
    {
        return getCurrentSession().createCriteria(c1ass).list();
    }

    @Override
    public T update(final T entity)
    {
        Assert.notNull(entity, "Entity to update must not be null");
        return (T) getCurrentSession().merge(entity);
    }

    @Override
    public void save(final T entity)
    {
        Assert.notNull(entity, "Entity to save must not be null");
        getCurrentSession().persist(entity);
    }

    @Override
    public void saveOrUpdate(final T entity)
    {
        Assert.notNull(entity, "Entity to save or update must not be null");
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(final T entity)
    {
        Assert.notNull(entity, "Entity to delete must not be null");
        getCurrentSession().delete(entity);
    }

    @Override
    public void deleteById(final Serializable id)
    {
        Assert.notNull(id, "ID must not be null");
        delete(getById(id));
    }
}
