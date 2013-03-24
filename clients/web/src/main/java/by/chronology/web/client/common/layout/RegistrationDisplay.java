package by.chronology.web.client.common.layout;

import by.chronology.web.client.common.BasePresenter;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;

/**
 * Registration form specific logic.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
@ImplementedBy(RegistrationView.class)
public interface RegistrationDisplay extends IsWidget
{
    interface Presenter extends BasePresenter
    {

    }

    void setPresenter(Presenter presenter);
}
