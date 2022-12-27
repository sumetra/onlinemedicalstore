package com.sumitra.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired 
	DataSource dataSource;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passwordEncoder)
		.usersByUsernameQuery("select uEmail,uPassword,uActive from user_details where uEmail=?")
		.authoritiesByUsernameQuery("select ud.uEmail, ur.rRole from user_details as ud, user_role as ur where ud.uId=ur.uId and uEmail=?");
		
		
		
	}
	
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/**").permitAll()
		.and()
		.formLogin()
		//.loginPage("/login")
		.loginProcessingUrl("/login")
		.usernameParameter("uEmail")
		.passwordParameter("uPassword")
		//.defaultSuccessUrl("/index")
		.successHandler(new CustomSuccessHandler())
		.failureUrl("/login?login_failed")
		.and()
		.logout()
		.logoutUrl("/logout")
		.invalidateHttpSession(true)
		.logoutSuccessUrl("/login?logout=true")
		.and()
		.csrf()
		.disable();
		
		
		
		
	
	}
	
	
	
}
