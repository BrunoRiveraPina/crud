package com.usuario.usr;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * ServletInitializer class
 * @author dave
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Method configure
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UsrCrudApplication.class);
	}

}
