package by.chronology.web.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Extends {@link GwtEvent} and implement <code>dispatch</code> method
 * that delegates handling to {@link BaseEventHandler}.
 * 
 * @author Tsimafei_Shchytkavets
 */
public abstract class BaseEvent<T> extends GwtEvent<BaseEventHandler<T>>
{
    @Override
    protected void dispatch(BaseEventHandler<T> handler)
    {
        handler.handleEvent((T) this);
    }
}
