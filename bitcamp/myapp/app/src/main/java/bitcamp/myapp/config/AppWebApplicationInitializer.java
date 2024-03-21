package bitcamp.myapp.config;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.*;
import java.io.File;
import java.util.EnumSet;

public class AppWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private final Log log = LogFactory.getLog(AppWebApplicationInitializer.class);

    public AppWebApplicationInitializer() {
        log.debug("생성자 호출됨");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/app/*"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(new MultipartConfigElement(
                new File("./temp").getAbsolutePath(),
                //new File(System.getProperty("java.io.tmpdir")).getAbsolutePath(),
                1024 * 1024 * 10,
                1024 * 1024 * 100,
                1024 * 1024 * 1
        ));
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[] {new CharacterEncodingFilter("UTF-8")};
    }

}
