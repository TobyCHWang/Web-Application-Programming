/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author toby
 */
public class LifectcleListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("APPLICATION CREATED:"+sce.getServletContext().getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
         System.out.println("APPLICATION STOPPED:"+sce.getServletContext().getContextPath());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session created: "+se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session stopped: "+se.getSession().getId());
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
          System.out.println("session attr added: "+se.getName()+"="+se.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("session attr removed: "+se.getName()+"="+se.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("SESSION attr updated: "+se.getName()+"changed from"+se.getValue()+"to"+se.getSession().getAttribute(se.getName()));
    }
}
