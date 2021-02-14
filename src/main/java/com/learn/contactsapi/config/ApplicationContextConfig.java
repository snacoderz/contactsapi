package com.learn.contactsapi.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationContextConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebContextConfig.class};  //provide the class which contains bean configurations
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/*"};
	}


	
}
