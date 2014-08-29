package by.chronology.core.service;

import by.chronology.core.model.TimeTag;

import java.util.Date;
import java.util.List;

/**
 * Contract for services that manipulate with <code>TimeTag</code> entities.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 11/9/12
 */
public interface TimeTagBusinessService
{
    /**
     * Create new time tag entity and store in database.
     *
     * @param timeTag entity need to be saved
     * @return stored entity
     */
    TimeTag createTimeTag(TimeTag timeTag);

    /**
     * Returns {@link java.util.List} of
     * {@link by.chronology.core.model.TimeTag} objects with timestamp between
     * <code>startDate</code> and <code>endDate</code>.
     * 
     * @param startDate
     *            starting of TimeTags
     * @param endDate
     *            ending if TimeTags
     * @return list of TimeTag objects
     */
    List<TimeTag> getTimeTags(Date startDate, Date endDate);

    /**
     * Deletes {@link by.chronology.core.model.TimeTag} record by
     * <code>id</code>.
     * 
     * @param id
     *            TimeTag identifier
     */
    void deleteTimeTag(Long id);
}
