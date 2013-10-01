package by.chronology.web.client.common.layout;

import by.chronology.web.client.service.rpc.TimeTagServiceAsync;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
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
    TrackView trackView;
    PlaceController placeController;
    TimeTagServiceAsync timeTagService;

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
        panel.setWidget(trackView.asWidget());
    }

    public void goTo(Place place)
    {
        placeController.goTo(place);
    }

    public void onTrack()
    {
        timeTagService.updateTimeTag(trackView.getTimeTag(), new AsyncCallback<Void>()
        {
            @Override
            public void onSuccess(Void result)
            {
                GWT.log("Time tag was successfully saved.");
            }

            @Override
            public void onFailure(Throwable caught)
            {
                GWT.log("Time tag wasn't saved.");
            }
        });
    }
}
