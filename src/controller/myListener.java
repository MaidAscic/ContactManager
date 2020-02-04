package controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class myListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
//		ServletContext sc = sce.getServletContext();
//		CurrentUser cu = new CurrentUser();
//		sc.setAttribute("currentUser", cu);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
