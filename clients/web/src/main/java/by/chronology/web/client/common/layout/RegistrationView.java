package by.chronology.web.client.common.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * Window with some required fields like name or email to register user in a system.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/1/13
 */
public class RegistrationView extends Composite implements RegistrationDisplay
{
    private Presenter presenter;

    @UiField
    Window registrationWindow;
    @UiField
    TextField emailField;
    @UiField
    TextField passwordField;
    @UiField
    TextField retypePasswordField;
    @UiField
    TextButton registerButton;
    @UiField
    TextButton cancelButton;

    interface MyUiBinder extends UiBinder<Window, RegistrationView>
    {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    public RegistrationView()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }

    public void show()
    {
        RootPanel.get().add(this);
        registrationWindow.show();
    }

    @UiHandler("registerButton")
    public void register(SelectEvent event)
    {
        //presenter.goTo();
    }

    @UiHandler("cancelButton")
    public void cancel(SelectEvent event)
    {
        //presenter.goTo();
    }
}
