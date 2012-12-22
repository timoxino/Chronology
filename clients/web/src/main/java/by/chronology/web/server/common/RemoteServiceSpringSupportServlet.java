package by.chronology.web.server.common;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * Base servlet for GWT application that enables Spring support.
 *
 * @author Tsimafei_Shchytkavets
 */
public class RemoteServiceSpringSupportServlet extends RemoteServiceServlet
{
    /**
     * Makes necessary preparations for Spring support.
     */
    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        AutowireCapableBeanFactory beanFactory = wac.getAutowireCapableBeanFactory();
        beanFactory.autowireBeanProperties(this, AutowireCapableBeanFactory.AUTOWIRE_NO, false);
    }
}
