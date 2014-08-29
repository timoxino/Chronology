package by.chronology.core.dao;

import by.chronology.common.dao.GenericDao;
import by.chronology.common.dao.criteria.DateRangeSearchCriteria;
import by.chronology.core.model.TimeTag;

import java.util.List;

/**
 * Interface for DAOs working with <code>TimeTag</code> entities.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 11/9/12
 */
public interface TimeTagDao extends GenericDao<TimeTag>
{
    /**
     * Returns {@link java.util.List} of
     * {@link by.chronology.core.model.TimeTag} objects with timestamps that fit
     * to {@link by.chronology.common.dao.criteria.DateRangeSearchCriteria}.
     * 
     * @param criteria
     *            search criteria based on start and end date
     * @return list of TimeTag objects
     */
    List<TimeTag> getByDates(DateRangeSearchCriteria criteria);
}
