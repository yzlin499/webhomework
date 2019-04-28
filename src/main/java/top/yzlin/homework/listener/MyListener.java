package top.yzlin.homework.listener;

import org.apache.catalina.core.ApplicationContextFacade;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("*********//////////////////**********");
        System.out.println(sce.getSource().getClass());
        ApplicationContextFacade facade = (ApplicationContextFacade) sce.getSource();
//        facade.servlet
//        org.apache.catalina.core.ApplicationContextFacade
        sce.getServletContext().getServletRegistrations().forEach((k, v) -> {
            System.out.print(k + "::");
            try {
                System.out.println(sce.getServletContext().getServlet(k));
            } catch (ServletException e) {
                e.printStackTrace();
            }
        });
        System.out.println("*********//////////////////**********");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
