package by.chronology.web.client.common.layout;

import by.chronology.web.client.event.ShowAlertEvent;
import by.chronology.web.client.service.rpc.TimeTagServiceAsync;

import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Control 'Track panel' with a life cycle managed by an ActivityManager.
 * 
 * @author Tsimafei Shchytkavets
 */
@Singleton
public class TrackActivity extends AbstractActivity
{
    @Inject
    NotificationMessages messages;
    TrackView trackView;
    PlaceController placeController;
    TimeTagServiceAsync timeTagService;
    EventBus eventBus;

    @Inject
    public TrackActivity(TrackView view, PlaceController controller, TimeTagServiceAsync timeTagServiceAsync)
    {
        timeTagService = timeTagServiceAsync;
        placeController = controller;
        trackView = view;
        trackView.setPresenter(this);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus)
    {
        this.eventBus = eventBus;
        panel.setWidget(trackView.asWidget());
    }

    public void onTrack()
    {
        timeTagService.updateTimeTag(trackView.getTimeTag(), new AsyncCallback<Void>()
        {
            @Override
            public void onSuccess(Void result)
            {
                eventBus.fireEvent(new ShowAlertEvent(AlertType.SUCCESS, messages.success(), messages.timeTagWasSaved()));
            }

            @Override
            public void onFailure(Throwable caught)
            {
                eventBus.fireEvent(new ShowAlertEvent(AlertType.ERROR, messages.failure(), messages.timeTagWasNotSaved()));
            }
        });
    }
}
