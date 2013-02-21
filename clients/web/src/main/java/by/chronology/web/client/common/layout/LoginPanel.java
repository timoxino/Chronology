package by.chronology.web.client.common.layout;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * Display panel with controls essential for login/sign up operation.
 * 
 * @author Tsimafei_Shchytkavets
 */
public class LoginPanel extends Composite
{
    @UiField
    TextField loginField;
    @UiField
    TextField passwordField;

    interface MyUiBinder extends UiBinder<VerticalPanel, LoginPanel>
    {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    public LoginPanel()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("login")
    public void login(SelectEvent event)
    {
        GWT.log("Login pressed, Login = " + loginField.getValue() + ", Password = " + passwordField.getValue());
    }

    @UiHandler("signup")
    public void signup(SelectEvent event)
    {
        GWT.log("Signup pressed, Login = " + loginField.getValue() + ", Password = " + passwordField.getValue());
    }
}
