package com.usuario.usr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * UsrCrudApplication class 
 * @author dave
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableWebSecurity
@ComponentScan(basePackages = { "com.usuario.usr" })
public class UsrCrudApplication extends WebSecurityConfigurerAdapter {

    /**
     * Configue method
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http
        .cors().and()
        .csrf().disable().authorizeRequests()
        .antMatchers("/**").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin();
    	
    }

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(UsrCrudApplication.class, args);
	}

}
