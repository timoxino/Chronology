package by.chronology.web.client.component;

import com.github.gwtbootstrap.client.ui.AlertBlock;
import com.github.gwtbootstrap.client.ui.constants.AlertType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * Wrapper for {@link AlertBlock} class that provides a convenient way to use alerts out of the box.
 * Hidden automatically(in 4 seconds by default).
 *
 * @author Tsimafei_Shchytkavets
 */
public class AlertComponent implements IsWidget
{
    private int TIME_TO_DISPLAY = 4;

    @UiField
    HTMLPanel panel;
    @UiField
    AlertBlock alert;

    interface MyUiBinder extends UiBinder<HTMLPanel, AlertComponent>
    {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    public AlertComponent()
    {
        uiBinder.createAndBindUi(this);
        alert.setVisible(false);
    }

    @Override
    public Widget asWidget()
    {
        return panel;
    }

    /**
     * Define time in seconds how long alert need to be displayed.
     */
    public void setTimeToDisplay(int timeToDisplay)
    {
        TIME_TO_DISPLAY = timeToDisplay;
    }

    /**
     * Display alert of particular <code>alertType</code> and with <code>heading</code>.
     *
     * @param alertType type of alert
     * @param heading text message in the header
     */
    public void show(AlertType alertType, String heading)
    {
        show(alertType, heading, null);
    }

    /**
     * Display alert of particular <code>alertType</code>, with <code>heading</code> and <code>message</code>.
     *
     * @param alertType type of alert
     * @param heading text message in the header
     * @param message alert text message
     */
    public void show(AlertType alertType, String heading, String message)
    {
        alert.setType(alertType);
        alert.setHeading(heading);
        alert.setText(message);
        alert.setVisible(true);
        hideAfterDelay(TIME_TO_DISPLAY);
    }

    private void hideAfterDelay(int delay)
    {
        final Timer timer = new Timer()
        {
            @Override
            public void run()
            {
                alert.setVisible(false);
            }
        };
        timer.schedule(delay * 1000);
    }

}
