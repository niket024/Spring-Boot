package com.javainuse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		
		// this section for request localhost:8080/employee?mediaType=json
		  configurer.favorPathExtension(false).favorParameter(true)
		 .parameterName("mediaType").ignoreAcceptHeader(true)
		 .useJaf(false).
		 defaultContentType(MediaType.APPLICATION_XML)
		 .mediaType("xml", MediaType.APPLICATION_XML)
		 .mediaType("json",MediaType.APPLICATION_JSON);
		 
		// This section is for request localhost:8080/employee.json
		/*configurer.favorPathExtension(true).favorParameter(false)
				.ignoreAcceptHeader(true).useJaf(false)
				.defaultContentType(MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML)
				.mediaType("json", MediaType.APPLICATION_JSON);*/

	}
}

//Note: .useJaf(false)
// this property determines whether to allow use of JAF (Java Activation Framework) 
//to resolve a path extension to a specific MediaType.