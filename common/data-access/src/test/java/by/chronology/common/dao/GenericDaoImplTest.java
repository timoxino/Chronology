package by.chronology.common.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/4/12
 */
public class GenericDaoImplTest
{
    private static final String ID = "id";

    private GenericDaoImpl genericDao;
    private Class c1ass;
    private Session session;
    private Object entityById;
    private Object mergedEntity;
    private Criteria allCriteria;
    private List<Object> allEntities;

    @Before
    public void setUp() throws Exception
    {
        // DAO initialization
        genericDao = new GenericDaoImpl(c1ass = Object.class);

        // mock objects
        genericDao.sessionFactory = mock(SessionFactory.class);
        session = mock(Session.class);
        allCriteria = mock(Criteria.class);

        // stubbing
        when(genericDao.sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.get(c1ass, ID)).thenReturn(entityById = new Object());
        when(session.createCriteria(c1ass)).thenReturn(allCriteria);
        when(session.merge(anyObject())).thenReturn(mergedEntity);
        when(allCriteria.list()).thenReturn(allEntities = Arrays.asList(new Object()));
    }

    @Test
    public void getCurrentSession() throws Exception
    {
        // target DAO invocation
        org.hibernate.Session currentSession = genericDao.getCurrentSession();

        // check expectations
        verify(genericDao.sessionFactory).getCurrentSession();

        // check result values
        Assert.assertThat("DAO should return genuine Session", currentSession, is((org.hibernate.Session) session));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByIdNull() throws Exception
    {
        genericDao.getById(null);
    }

    @Test
    public void getById() throws Exception
    {
        // target DAO invocation
        Object entity = genericDao.getById(ID);

        // check expectations
        verify(session).get(c1ass, ID);

        // check result values
        Assert.assertThat("DAO should return genuine Entity", entity, is(entityById));
    }

    @Test
    public void getAll() throws Exception
    {
        // target DAO invocation
        List<Object> all = genericDao.getAll();

        // check expectations
        verify(allCriteria).list();

        // check result values
        Assert.assertThat("DAO should return all entities provided by Session", all, is(allEntities));
    }

    @Test(expected = IllegalArgumentException.class)
    public void updateNull() throws Exception
    {
        genericDao.update(null);
    }

    @Test
    public void update() throws Exception
    {
        // target DAO invocation
        final Object entityToUpdate = new Object();
        final Object updatedEntity = genericDao.update(entityToUpdate);

        // check expectations
        verify(session).merge(entityToUpdate);

        // check result values
        Assert.assertThat("DAO should return genuine updated Entity", updatedEntity, is(mergedEntity));
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveNull() throws Exception
    {
        genericDao.save(null);
    }

    @Test
    public void save() throws Exception
    {
        // target DAO invocation
        final Object entityToSave = new Object();
        genericDao.save(entityToSave);

        // check expectations
        verify(session).persist(entityToSave);
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveOrUpdateNull() throws Exception
    {
        genericDao.saveOrUpdate(null);
    }

    @Test
    public void saveOrUpdate() throws Exception
    {
        // target DAO invocation
        final Object entityToSave = new Object();
        genericDao.saveOrUpdate(entityToSave);

        // check expectations
        verify(session).saveOrUpdate(entityToSave);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteNull() throws Exception
    {
        genericDao.delete(null);
    }

    @Test
    public void delete() throws Exception
    {
        // target DAO invocation
        final Object entityToDelete = new Object();
        genericDao.delete(entityToDelete);

        // check expectations
        verify(session).delete(entityToDelete);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteByIdNull() throws Exception
    {
        genericDao.deleteById(null);
    }

    @Test
    public void deleteById() throws Exception
    {
        // target DAO invocation
        genericDao.deleteById(ID);

        // check expectations
        verify(session).get(c1ass, ID);
        verify(session).delete(entityById);
    }
}
