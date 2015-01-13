package by.chronology.web.client.event;

import org.gwtbootstrap3.client.ui.constants.AlertType;

/**
 * @author Tsimafei_Shchytkavets
 */
public class ShowAlertEvent extends BaseEvent<ShowAlertEvent>
{
    public static Type<BaseEventHandler<ShowAlertEvent>> TYPE = new Type<BaseEventHandler<ShowAlertEvent>>();
    private AlertType alertType;
    private String heading;
    private String message;

    public ShowAlertEvent(AlertType alertType, String heading, String message)
    {
        this.alertType = alertType;
        this.heading = heading;
        this.message = message;
    }

    @Override
    public Type<BaseEventHandler<ShowAlertEvent>> getAssociatedType()
    {
        return TYPE;
    }

    public AlertType getAlertType()
    {
        return alertType;
    }

    public String getHeading()
    {
        return heading;
    }

    public String getMessage()
    {
        return message;
    }
}
