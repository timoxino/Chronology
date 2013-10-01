package by.chronology.web.client.service.rpc;

import by.chronology.web.client.model.TimeTag;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

/**
 * Contract for servlet service that manipulate with <code>TimeTag</code> entities.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 12/9/12
 */
@RemoteServiceRelativePath("services/timeTagService")
public interface TimeTagService extends RemoteService
{
    /**
     * Updates time tag or creates new one if doesn't exist.
     *
     * @param timeTag entity need to be updated or created.
     */
    void updateTimeTag(TimeTag timeTag);

    /**
     * Returns all available time tags.
     *
     * @return
     *      list of time tags
     */
    List<TimeTag> getAllTimeTags();
}
