package by.chronology.web.client.common;

import com.google.gwt.place.shared.Place;

/**
 * Base interface for all presenters.
 * Should be used for navigation logic.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 10/22/12
 */
public interface BasePresenter
{
    /**
     * Declares method that is used for navigation between places.
     */
    void goTo(Place place);

}
