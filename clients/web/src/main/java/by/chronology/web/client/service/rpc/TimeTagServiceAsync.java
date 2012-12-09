package by.chronology.web.client.service.rpc;

import by.chronology.web.client.model.TimeTag;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * GWT client side stub for rpc service <code>TimeTagService</code>.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/9/12
 */
public interface TimeTagServiceAsync
{
    /**
     * Returns all available time tags.
     */
    void getAllTimeTags(AsyncCallback<List<TimeTag>> callback);
}
