package by.chronology.service;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Entry point for modern web applications. Create and initialize
 * <code>Spring</code> context, declare and map <code>Servlets</code>.
 * 
 * @author Tsimafei_Shchytkavets
 */
public class RestInitializer implements WebApplicationInitializer
{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        final AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.register(RestSpringConfiguration.class);

        servletContext.addListener(new ContextLoaderListener(springContext));

        final ServletRegistration.Dynamic timeTagServlet = servletContext.addServlet("timeTrackerDispatcher", DispatcherServlet.class);
        timeTagServlet.setInitParameter("contextConfigLocation", "/WEB-INF/classes/rest-service-config.xml");
        timeTagServlet.addMapping("/TimeTracker/*");
        timeTagServlet.setLoadOnStartup(1);
    }
}
