package by.chronology.web.server.config;

import by.chronology.web.server.rpc.TimeTagServiceImpl;
import by.chronology.web.server.rpc.UserServiceImpl;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Entry point for modern web application.
 * Create and initialize <code>Spring</code> context, declare and map <code>Servlets</code>.
 *
 * @author Tsimafei_Shchytkavets
 */
public class TimeTrackerInitializer implements WebApplicationInitializer
{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        final AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.register(TimeTrackerConfiguration.class);

        servletContext.addListener(new ContextLoaderListener(springContext));

        final ServletRegistration.Dynamic timeTagServlet = servletContext.addServlet("timeTagServlet", TimeTagServiceImpl.class);
        timeTagServlet.addMapping("/services/timeTagService");
        timeTagServlet.setLoadOnStartup(1);

        final ServletRegistration.Dynamic userServlet = servletContext.addServlet("userServlet", UserServiceImpl.class);
        userServlet.addMapping("/services/userService");
    }
}
