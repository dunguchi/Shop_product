package com.dunght.shop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.dunght.shop.security.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	    private UserDetailsServiceImpl userDetailsService;

	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                .antMatchers("/register").permitAll()
	                .antMatchers("/login").permitAll()
	                .antMatchers("/").hasRole("MEMBER")
	                .antMatchers("/admin").hasRole("ADMIN")
	                .and()
	            .formLogin()
	                .loginPage("/login")
//	                .loginProcessingUrl("/loginsystem")
	                .usernameParameter("username")
	                .passwordParameter("password")
	                .defaultSuccessUrl("/")
	                .failureUrl("/login?error")
	                .and()
	            .exceptionHandling()
	                .accessDeniedPage("/403");
	    }
}
