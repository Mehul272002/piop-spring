package com.codespring.poip;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.core.annotation.Order;




@Configuration
@EnableWebSecurity
@Order(1)
//@AutoConfigureOrder(1000) 
public class adminSecurityConfig extends WebSecurityConfigurerAdapter {
	

	    	
	    	@Bean
	    	public BCryptPasswordEncoder adminPasswordEncoder() {
	    	    return new BCryptPasswordEncoder();
	    	}
	    	
	    	
			@Bean
			public UserDetailsService adminDetailsService()
			{
				return new CustomAdminDetailService();
			}
			
			

			@Bean
			public DaoAuthenticationProvider adminauthenticationProvider() {
			    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
			    authProvider.setUserDetailsService(adminDetailsService());
			    authProvider.setPasswordEncoder(adminPasswordEncoder());
			     return authProvider;
			}
			
			@Override
	    	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	     auth.authenticationProvider(adminauthenticationProvider());
	    	 }
	    	
			@Override
	        protected void configure(HttpSecurity http) throws Exception {
	        	http.authorizeRequests()
	            .antMatchers("/users").authenticated()
	            .anyRequest().permitAll()
	            .and()
	            .formLogin()
	            	.loginPage("/admin")
	                .usernameParameter("email")
	                .passwordParameter("password")
	                .defaultSuccessUrl("/adminSucess")
	                .failureUrl("/tempSucess")
	                .permitAll()
	            .and()
	            .logout().permitAll();
	        }
	    }

	    
	
	
	




