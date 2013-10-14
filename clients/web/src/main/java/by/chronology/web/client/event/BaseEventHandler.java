package by.chronology.web.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Extends {@link EventHandler} class by introducing common <code>handleEvent</code> method.
 *
 * @author Tsimafei_Shchytkavets
 */
public interface BaseEventHandler<T> extends EventHandler
{
    void handleEvent(T event);
}
