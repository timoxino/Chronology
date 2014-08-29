package by.chronology.core.dao;

import by.chronology.common.dao.criteria.DateRangeSearchCriteria;
import by.chronology.common.dao.impl.GenericDaoImpl;
import by.chronology.core.model.TimeTag;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Data Access Object for manipulating with <code>TimeTag</code> objects.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 11/4/12
 */
@Repository(value = "timeTagDao")
public class TimeTagDaoImpl extends GenericDaoImpl<TimeTag> implements TimeTagDao
{
    /**
     * Instantiate DAO based on <code>TimeTag</code> class.
     */
    public TimeTagDaoImpl()
    {
        super(TimeTag.class);
    }

    @Override
    public List<TimeTag> getByDates(DateRangeSearchCriteria searchCriteria)
    {
        Assert.notNull(searchCriteria, "Search criteria must not be null");

        final Criteria criteria = getCurrentSession().createCriteria(TimeTag.class);
        if (searchCriteria.getStartDate() != null && searchCriteria.getEndDate() != null)
        {
            criteria.add(Restrictions.between("tagTimestamp", searchCriteria.getStartDate(),
                    searchCriteria.getEndDate()));
        }
        else
        {
            if (searchCriteria.getStartDate() != null)
            {
                criteria.add(Restrictions.ge("tagTimestamp", searchCriteria.getStartDate()));
            }
            if (searchCriteria.getEndDate() != null)
            {
                criteria.add(Restrictions.le("tagTimestamp", searchCriteria.getEndDate()));
            }
        }

        return criteria.list();
    }
}
