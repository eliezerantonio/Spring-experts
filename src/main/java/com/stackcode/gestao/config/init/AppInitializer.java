package com.stackcode.gestao.config.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.stackcode.gestao.config.WebConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
	
		return new Class<?> []{ WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
	
		return new String[]{"/"};
	}

}
