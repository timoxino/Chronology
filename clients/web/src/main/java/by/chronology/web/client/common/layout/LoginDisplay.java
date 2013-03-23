package by.chronology.web.client.common.layout;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;

/**
 * Login form specific logic.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
@ImplementedBy(LoginView.class)
public interface LoginDisplay extends IsWidget
{
    interface Presenter
    {
        void goTo(Place place);
    }

    void setPresenter(Presenter presenter);
}
