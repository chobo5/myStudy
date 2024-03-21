package bitcamp.myapp.config;

import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.io.File;
import java.util.EnumSet;

public class AppWebApplicationInitializer2 /*extends AbstractContextLoaderInitializer*/ {
    AnnotationConfigWebApplicationContext rootContext;
//    @Override
    protected WebApplicationContext createRootApplicationContext() {
        rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(RootConfig.class);
        rootContext.refresh();
        return rootContext;
    }

//    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //수퍼 클래스의 onStartup()에서 ContextLoaderListener를 생성하기 떄문에
        //기존의 기능을 그대로 수행하도록 클래스의 메서드를 호출한다.
//        super.onStartup(servletContext);
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);
        appContext.setParent(rootContext);
        appContext.setServletContext(servletContext);
        appContext.refresh();
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", new DispatcherServlet(appContext));
        registration.addMapping("/app/*");
        registration.setLoadOnStartup(1);
        registration.setMultipartConfig(new MultipartConfigElement(
                new File("./temp").getAbsolutePath(),
                //new File(System.getProperty("java.io.tmpdir")).getAbsolutePath(),
                1024 * 1024 * 10,
                1024 * 1024 * 100,
                1024 * 1024 * 1
        ));

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8");
        FilterRegistration.Dynamic filterRegistration =
                servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        filterRegistration.addMappingForServletNames(
                EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE),
                false,
                new String[] {"app"}
        );


    }
}
