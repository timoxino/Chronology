package by.chronology.web.server.rpc;

import by.chronology.web.client.model.TimeTag;
import by.chronology.web.client.service.rpc.TimeTagService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.ArrayList;
import java.util.List;

/**
 * Servlet for GWT client that provides functionality related to TimeTag entities.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/9/12
 */
public class TimeTagServiceImpl extends RemoteServiceServlet implements TimeTagService
{
    @Override
    public List<TimeTag> getAllTimeTags()
    {
        // TODO: Temporary implementation. Should be replaced with real.
        return new ArrayList<TimeTag>();
    }
}
