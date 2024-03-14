package bitcamp.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplicationInitializerImpl extends AbstractDispatcherServletInitializer {

    private static Log log = LogFactory.getLog(WebApplicationInitializerImpl.class);
    AnnotationConfigWebApplicationContext rootContext;

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        rootContext.refresh();
        return rootContext;
    }

    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);
        appContext.setParent(rootContext);
        appContext.refresh();
        return appContext;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }

    @Override
    protected String getServletName() {
        return "app";
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.debug("onStartup() 호출됨");
        super.onStartup(servletContext);


        AnnotationConfigWebApplicationContext adminContext = new AnnotationConfigWebApplicationContext();
        adminContext.register(AdminConfig.class);
        adminContext.setParent(rootContext);
        adminContext.refresh();
        ServletRegistration.Dynamic adminServletRegistration = servletContext.addServlet("admin", new DispatcherServlet(adminContext));
        adminServletRegistration.addMapping("/admin/*");
        adminServletRegistration.setLoadOnStartup(1);

    }
}
