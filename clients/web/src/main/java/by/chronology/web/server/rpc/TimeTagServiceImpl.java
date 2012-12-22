package by.chronology.web.server.rpc;

import by.chronology.core.service.TimeTagBusinessService;
import by.chronology.web.client.model.TimeTag;
import by.chronology.web.client.service.rpc.TimeTagService;
import by.chronology.web.server.common.RemoteServiceSpringSupportServlet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Servlet for GWT client that provides functionality related to TimeTag entities.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/9/12
 */
public class TimeTagServiceImpl extends RemoteServiceSpringSupportServlet implements TimeTagService
{
    @Autowired
    TimeTagBusinessService timeTagBusinessService;

    @Override
    public List<TimeTag> getAllTimeTags()
    {
        // TODO: Temporary implementation. Should be replaced with real.
        return new ArrayList<TimeTag>();
    }
}
