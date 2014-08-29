package by.chronology.core.service;

import by.chronology.common.dao.criteria.DateRangeSearchCriteria;
import by.chronology.core.dao.TimeTagDao;
import by.chronology.core.model.TimeTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Business service provides functionality to work with <code>TimeTag</code> objects.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 11/9/12
 */
@Service(value = "timeTagBusinessService")
public class TimeTagBusinessServiceImpl implements TimeTagBusinessService
{
    @Autowired
    TimeTagDao timeTagDao;

    @Override
    public TimeTag createTimeTag(TimeTag timeTag)
    {
        timeTagDao.save(timeTag);
        return timeTag;
    }

    @Override
    public List<TimeTag> getTimeTags(Date startDate, Date endDate)
    {

        final DateRangeSearchCriteria searchCriteria = new DateRangeSearchCriteria();
        searchCriteria.setStartDate(startDate);
        searchCriteria.setEndDate(endDate);
        return timeTagDao.getByDates(searchCriteria);
    }

    @Override
    public void deleteTimeTag(Long id)
    {
        timeTagDao.deleteById(id);
    }
}
