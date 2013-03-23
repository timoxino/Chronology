package by.chronology.web.client.common.layout;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;
import com.sencha.gxt.widget.core.client.ContentPanel;

/**
 * Main layout specific logic.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
@ImplementedBy(MainLayoutView.class)
public interface MainLayoutDisplay extends IsWidget
{
    interface Presenter
    {

        void goTo(Place place);
    }
    void setPresenter(Presenter presenter);

    ContentPanel getNavigationPanel();

    ContentPanel getHeaderPanel();

    ContentPanel getBodyPanel();

    ContentPanel getFooterPanel();
}
