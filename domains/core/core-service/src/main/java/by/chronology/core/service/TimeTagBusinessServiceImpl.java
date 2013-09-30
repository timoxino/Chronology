package by.chronology.core.service;

import by.chronology.core.dao.TimeTagDao;
import by.chronology.core.model.TimeTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<TimeTag> getAllTimeTags()
    {
        return timeTagDao.getAll();
    }

    @Override
    public TimeTag createTimeTag(TimeTag timeTag)
    {
        timeTagDao.save(timeTag);
        return timeTag;
    }
}
