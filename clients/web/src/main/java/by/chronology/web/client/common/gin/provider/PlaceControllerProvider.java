package by.chronology.web.client.common.gin.provider;

import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Creates instance of PlaceController with pre-configured event bus.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
public class PlaceControllerProvider implements Provider<PlaceController>
{
    @Inject
    EventBus eventBus;

    @Override
    public PlaceController get()
    {
        return new PlaceController(eventBus);
    }
}
