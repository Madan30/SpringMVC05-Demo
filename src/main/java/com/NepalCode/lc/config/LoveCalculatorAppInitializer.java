package com.NepalCode.lc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LoveCalculatorAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {

		XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
		webApplicationContext.setConfigLocation("classpath:beans.xml");

		// create a dispatcher servlet object
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);

		// Register the dispatcher servlet with servlet context
		ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("myDispatcherServlet",
				dispatcherServlet);
		
		myCustomDispatcherServlet.setLoadOnStartup(1);
		myCustomDispatcherServlet.addMapping("/home/*");

	}

}
