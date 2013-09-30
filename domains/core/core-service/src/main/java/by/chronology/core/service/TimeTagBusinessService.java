package by.chronology.core.service;

import by.chronology.core.model.TimeTag;

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
     * Returns all available time tags.
     *
     * @return
     *      list of time tags
     */
    List<TimeTag> getAllTimeTags();

    /**
     * Create new time tag entity and store in database.
     *
     * @param timeTag entity need to be saved
     * @return stored entity
     */
    TimeTag createTimeTag(TimeTag timeTag);
}
