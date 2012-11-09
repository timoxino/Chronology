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
@Service(value = "timeTagService")
public class TimeTagServiceImpl implements TimeTagService
{
    @Autowired
    TimeTagDao timeTagDao;

    @Override
    public List<TimeTag> getAllTimeTags()
    {
        return timeTagDao.getAll();
    }
}
