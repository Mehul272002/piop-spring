package com.codespring.poip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(2)
@EnableWebSecurity
//@AutoConfigureOrder(0)
public class studentLoginSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	
	   
	    	@Bean
	      	public BCryptPasswordEncoder passwordEncoder() {
	    	    return new BCryptPasswordEncoder();
	    	}
	    	
	    	
			@Bean
			public UserDetailsService userDetailsService()
			{
				return new CustomUserDetailService();
			}
			
			

			@Bean
			public DaoAuthenticationProvider authenticationProvider() {
			    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
			    authProvider.setUserDetailsService(userDetailsService());
			    authProvider.setPasswordEncoder(passwordEncoder());
			     return authProvider;
			}
			
			@Override
		     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				    auth.authenticationProvider(authenticationProvider());
				}
	    	
	    	
	        @Override
	        protected void configure(HttpSecurity http) throws Exception {
	        	http.authorizeRequests()
	            .antMatchers("/users").authenticated()
	            .anyRequest().permitAll()
	            .and()
	            .formLogin()
	            	.loginPage("/login")
	                .usernameParameter("email")
	                .passwordParameter("password")
	                .defaultSuccessUrl("/tempSucess")
	                .permitAll()
	            .and()
	            .logout().permitAll();
	        }
	    }
	    

	    
	    
	   