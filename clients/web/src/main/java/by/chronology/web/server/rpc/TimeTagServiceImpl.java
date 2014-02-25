package by.chronology.web.server.rpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import by.chronology.web.client.model.TimeTag;
import by.chronology.web.client.service.rpc.TimeTagService;
import by.chronology.web.server.common.RemoteServiceSpringSupportServlet;

/**
 * Servlet for GWT client that provides functionality related to TimeTag entities.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/9/12
 */
public class TimeTagServiceImpl extends RemoteServiceSpringSupportServlet implements TimeTagService
{
    final static Logger LOGGER = LoggerFactory.getLogger(TimeTagServiceImpl.class);
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DozerBeanMapper mapper;

    @Override
    public void updateTimeTag(TimeTag timeTag)
    {
        LOGGER.debug("Update time tag servlet operation has been started...");
        if (timeTag.getId() == null)
        {
            restTemplate.postForObject("http://127.0.0.1:9090/timeTags", timeTag, TimeTag.class);
        }
        else
        {
            // TODO: update functionality will be implemented later
        }
    }

    @Override
    public List<TimeTag> getAllTimeTags()
    {
        // TODO: Temporary implementation that return list with one particular item
        final by.chronology.core.model.TimeTag timeTag = restTemplate.getForObject("http://127.0.0.1:9090/timeTags/1", by.chronology.core.model.TimeTag.class);
        return populateTimeTagsUI(Arrays.asList(timeTag));
    }

    List<TimeTag> populateTimeTagsUI(List<by.chronology.core.model.TimeTag> timeTagsModel)
    {
        final ArrayList<TimeTag> timeTagsUI = new ArrayList<TimeTag>();
        for (by.chronology.core.model.TimeTag timeTagModel : timeTagsModel)
        {
            timeTagsUI.add(mapper.map(timeTagModel, TimeTag.class));
        }
        return timeTagsUI;
    }
}
