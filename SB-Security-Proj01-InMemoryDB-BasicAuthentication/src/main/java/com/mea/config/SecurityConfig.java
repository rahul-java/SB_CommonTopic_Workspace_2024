package com.mea.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// for Authentication info provider configuration
		/*
		auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("rajesh").password("{noop}rajesh").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("mahesh").password("{noop}mahesh").roles("MANAGER","CUSTOMER");
		auth.inMemoryAuthentication().withUser("suresh").password("{noop}suresh").roles("VISITOR");
		*/
		
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$o/OMcIoEVCyS6ifqBfRFfutGupOE9BkKlafSLnCvBsGzUEwTemQ8i").roles("CUSTOMER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("rajesh").password("$2a$10$t8nWuh68qVyceEfTaTvHq..d7zxht/GeRSsT/tuR2Y60XoIgEa19m").roles("MANAGER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("mahesh").password("$2a$10$OEg6N2LMcWNZFMLLVgtnK.wx4FlyO53pIRY8bn/wBtLjXxGMbzYhm").roles("MANAGER","CUSTOMER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("suresh").password("$2a$10$JCCWUoI8f/MNQVVv0kQZnORx/o3NP.Bw5VuSTMNc6YpgYGfMmEjGO").roles("VISITOR");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Configure Authentication + Authorization on the urls
		http.authorizeHttpRequests().antMatchers("/").permitAll()
		    .antMatchers("/offers").authenticated()
		    .antMatchers("/balance").hasAnyRole("CUSTOMER","MANAGER")
		    .antMatchers("/loanApprove").hasRole("MANAGER")
		    .anyRequest().authenticated()
		    //.and().httpBasic() //enables Authentication uses browser generated dialog box asking for uname and pwd
		    .and().formLogin() //for form based authentication
		    .and().rememberMe() // this feature is not working properly
		    .and().logout()
		    .and().exceptionHandling().accessDeniedPage("/denied") // for configuring custom page for authorization failure
		    .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}
}

