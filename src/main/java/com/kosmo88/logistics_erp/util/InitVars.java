package com.kosmo88.logistics_erp.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitVars implements ServletContextListener{

	public InitVars() {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("contextPath", sce.getServletContext().getContextPath());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
