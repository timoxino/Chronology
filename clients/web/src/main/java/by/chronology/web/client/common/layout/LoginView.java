package by.chronology.web.client.common.layout;

import by.chronology.web.client.model.UserAccount;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * Display panel with controls essential for login/sign up operation.
 * 
 * @author Tsimafei_Shchytkavets
 */
public class LoginView extends Composite implements LoginDisplay
{
    private Presenter presenter;

    @UiField
    TextField loginField;
    @UiField
    TextField passwordField;
    @UiField
    FormPanel formPanel;

    @Override
    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }

    interface MyUiBinder extends UiBinder<VerticalPanel, LoginView>
    {
    }

    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    public LoginView()
    {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("login")
    public void onLogin(SelectEvent event)
    {
        if (formPanel.isValid())
        {
            presenter.onLogin(new UserAccount());
        }
    }

    @UiHandler("signup")
    public void onSignup(SelectEvent event)
    {
        presenter.onSignup(new UserAccount());
    }
}
