package com.eldarian.dealerstat.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;



//    public class AppInitializer extends
//            AbstractAnnotationConfigDispatcherServletInitializer {
//
//        @Override
//        protected Class<?>[] getRootConfigClasses() {
//            return new Class[] { HibernateConfig.class };
//        }
//
//        @Override
//        protected Class<?>[] getServletConfigClasses() {
//            return new Class[] { WebMvcConfig.class };
//        }
//
//        @Override
//        protected String[] getServletMappings() {
//            return new String[] { "/" };
//        }
//    }

public class AppInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        context.setServletContext(container);

        ServletRegistration.Dynamic servlet = container.addServlet(
                "dispatcher", new DispatcherServlet(context));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

    }
}
