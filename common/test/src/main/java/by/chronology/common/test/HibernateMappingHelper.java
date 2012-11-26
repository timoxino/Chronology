package by.chronology.common.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.EntityPersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Class helps to check mapping accuracy.
 *
 * @author Tsimafei_Shchytkavets
 */
public class HibernateMappingHelper
{
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernateMappingHelper.class);

    /**
     * Iterates through all available entities and checks mapping accuracy.
     *
     * @param sessionFactory
     *          instance of Hibernate session factory.
     * @param maxResults
     *          results number
     */
    public static final void testHibernateMapping(final SessionFactory sessionFactory, boolean maxResults)
    {
        boolean errorStatus = false;
        final Map classMetadata = sessionFactory.getAllClassMetadata();
        final Map<String, Exception> entityStatus = new HashMap<String, Exception>();

        for (Iterator iterator = classMetadata.values().iterator(); iterator.hasNext();)
        {
            String className = null;
            Session session = sessionFactory.openSession();
            try
            {
                final EntityPersister persister = (EntityPersister) iterator.next();
                className = persister.getClassMetadata().getEntityName();
                LOGGER.error("---------------" + className + "----------------------------");
                testHibernate(maxResults, className, session);
            }
            catch (final Exception exception)
            {
                errorStatus = true;
                entityStatus.put(className, exception);
            }
            finally
            {
                session.close();
            }
        }
        LOGGER.error("--------------------*****************************-----------------------");

        for (Map.Entry<String, Exception> entry : entityStatus.entrySet())
        {
            LOGGER.error(buildResultString(entry));
        }
        LOGGER.error("--------------------****************************-----------------------");

        Assert.state(!errorStatus, buildErrorString(entityStatus));
    }

    public static final void testHibernateMapping(final SessionFactory sessionFactory)
    {
        testHibernateMapping(sessionFactory, false);
    }

    private static void testHibernate(boolean maxResults, String className, Session session)
    {
        if (maxResults)
        {
            session.createQuery("from " + className + " c").setMaxResults(1).list();
        }
        else
        {
            session.createQuery("from " + className + " c").list();
        }
    }

    private static String buildErrorString(Map<String, Exception> entityStatus)
    {
        StringBuilder results = new StringBuilder("\n");
        for (Map.Entry<String, Exception> entry : entityStatus.entrySet())
        {
            if (entry.getValue() != null)
                results.append(buildResultString(entry)).append("\n");
        }
        return results.toString();
    }

    private static String buildResultString(Map.Entry<String, Exception> entry)
    {
        if (entry.getValue() == null)
        {
            return entry.getKey() + " : Successfully mapped";
        }
        else
        {
            Exception e = entry.getValue();
            return entry.getKey() + " : " + (e.getCause() == null ? e.toString() : e.getCause().toString());
        }
    }
}
