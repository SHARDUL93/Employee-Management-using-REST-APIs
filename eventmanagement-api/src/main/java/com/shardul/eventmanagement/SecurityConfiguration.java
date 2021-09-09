package com.shardul.eventmanagement;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends  WebSecurityConfigurerAdapter{
	
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//super.configure(auth);
		auth.inMemoryAuthentication()
		.withUser("shardul")
		.password("{noop}1234")
		.roles("USER")
		.and()
		.withUser("admin")
		.password("{noop}admin")
		.roles("ADMIN");
	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
		//super.configure(http);	
		http.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, "/events")
		.hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/events/**")
		.hasRole("ADMIN")
		.antMatchers(HttpMethod.PATCH, "/events/**")
		.hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, "/events/**")
		.hasRole("ADMIN")
		.and()
		.csrf().disable();
	}
	

}
