package by.chronology.web.client.common;

import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Base interface for presenters.
 * Should be used for navigation logic.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/22/12
 */
public interface Presenter
{
    /**
     * Sets presenter's view into <code>container</code>.
     *
     * @param container Container to which presenter's view will be set.
     */
    public void go(HasWidgets container);
}
