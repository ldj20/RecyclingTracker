package com.RecyclingTrackerAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
    		.headers().frameOptions().disable()
    		.and()
    		.csrf()
	    	.disable()
	    	.authorizeRequests()
	        .antMatchers(HttpMethod.POST,"/users").permitAll()
	        .antMatchers(HttpMethod.GET, "/users").permitAll()
	        .antMatchers(HttpMethod.GET,"/users/*").permitAll()
	        .antMatchers(HttpMethod.PUT,"/users/*").permitAll()
	        .antMatchers(HttpMethod.DELETE,"/users").permitAll()
	        .anyRequest()
	        .authenticated()
	        .and()
	        .httpBasic()
    		.and().formLogin().permitAll();
    	
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}