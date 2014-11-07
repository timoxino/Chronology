import by.chronology.common.test.HibernateMappingHelper;
import by.chronology.core.config.CoreModelMappingTestConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tsimafei Shchytkavets
 *         Creation Date: 11/18/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreModelMappingTestConfiguration.class})
@Transactional
public class CoreModelMappingTest
{
    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testTimeTagEntity()
    {
        HibernateMappingHelper.testHibernateMapping(sessionFactory);
    }
}
