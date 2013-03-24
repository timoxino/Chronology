package by.chronology.web.client.common.layout;

import by.chronology.web.client.common.BasePresenter;
import by.chronology.web.client.model.UserAccount;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;

/**
 * Login form specific logic.
 *
 * @author Tsimafei Shchytkavets
 *         Creation Date: 3/2/13
 */
@ImplementedBy(LoginView.class)
public interface LoginDisplay extends IsWidget
{
    interface Presenter extends BasePresenter
    {
        /**
         * Performs an action when login is happening.
         *
         * @param userAccount
         *          user data
         */
        void onLogin(UserAccount userAccount);

        /**
         * Performs an action when registration is happening,
         */
        void onSignup();
    }

    void setPresenter(Presenter presenter);
}
