package com.flow.mo.api.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

	
	@Bean
	public FilterRegistrationBean<CORSFilter> myFilterBean() {
	  final FilterRegistrationBean<CORSFilter> filterRegBean = new FilterRegistrationBean<CORSFilter>();
	  filterRegBean.setFilter(new CORSFilter());
	  filterRegBean.addUrlPatterns("/*");
	  filterRegBean.setEnabled(Boolean.TRUE);
	  filterRegBean.setName("CORS Filter");
	  filterRegBean.setAsyncSupported(Boolean.TRUE);
	  return filterRegBean;
	}
}
