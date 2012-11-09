package by.chronology.core.dao;

import by.chronology.common.dao.GenericDao;
import by.chronology.core.model.TimeTag;

/**
 * Data Access Object for manipulating with <code>TimeTag</code> objects.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 11/4/12
 */
public class TimeTagDaoImpl extends GenericDao<TimeTag>
{
    /**
     * Instantiate DAO based on <code>class</code>.
     *
     * @param c1ass Class will be used by DAO
     */
    public TimeTagDaoImpl(Class<TimeTag> c1ass)
    {
        super(c1ass);
    }
}
