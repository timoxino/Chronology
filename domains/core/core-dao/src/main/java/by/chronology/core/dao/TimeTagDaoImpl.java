package by.chronology.core.dao;

import by.chronology.common.dao.GenericDaoImpl;
import by.chronology.core.model.TimeTag;

/**
 * Data Access Object for manipulating with <code>TimeTag</code> objects.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 11/4/12
 */
public class TimeTagDaoImpl extends GenericDaoImpl<TimeTag> implements TimeTagDao
{
    /**
     * Instantiate DAO based on <code>TimeTag</code> class.
     */
    public TimeTagDaoImpl()
    {
        super(TimeTag.class);
    }
}
