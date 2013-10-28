package by.chronology.web.client.notification;

import by.chronology.web.client.component.AlertComponent;
import by.chronology.web.client.event.BaseEventHandler;
import by.chronology.web.client.event.ShowAlertEvent;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Control 'Notification area' with a life cycle managed by an ActivityManager.
 * 
 * @author Tsimafei Shchytkavets
 */
@Singleton
public class NotificationActivity extends AbstractActivity implements BaseEventHandler<ShowAlertEvent>
{
    PlaceController placeController;
    AlertComponent alertComponent;

    @Inject
    public NotificationActivity(PlaceController controller, AlertComponent alert)
    {
        placeController = controller;
        alertComponent = alert;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus)
    {
        panel.setWidget(alertComponent);
    }

    @Override
    public void handleEvent(ShowAlertEvent event)
    {
        alertComponent.show(event.getAlertType(), event.getHeading(), event.getMessage());
    }
}
