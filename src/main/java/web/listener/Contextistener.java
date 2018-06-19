package web.listener;


import dao.PersonalDAO;
import dao.ProfesionDAO;
import dao.mysql.PersonalDAOImpl;
import dao.mysql.ProfesionDAOImpl;
import services.serviceImpl.PersonalServiceImpl;
import services.serviceInterface.PersonalService;
import transaction.TransactionManager;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.sql.DataSource;

@WebListener()
public class Contextistener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    private final String pathToDataBase;
    // Public constructor is required by servlet spec
    public Contextistener() {
            pathToDataBase = "java:/comp/env/jdbc/hospitaldb";
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        DataSource dataSource=null;
        try {
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup(pathToDataBase);
            System.out.println(1);
        } catch (NamingException e) {
            e.printStackTrace();
        }

        TransactionManager transactionManager = new TransactionManager(dataSource);
        PersonalDAOImpl personalDAO = new PersonalDAOImpl();
        PersonalService personalService = new PersonalServiceImpl(personalDAO,transactionManager);
        servletContext.setAttribute("service", personalService);
        servletContext.setAttribute("transactionManager", transactionManager);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
