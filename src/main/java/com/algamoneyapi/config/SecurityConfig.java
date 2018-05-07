package com.algamoneyapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
* A anotação ResourceServerConfigurerAdapter gera um WebSecurityConfigurerAdapter.
* A Order do WebSecurityConfigurerAdapter gerado pelo ResourceServerConfigurerAdapter é 3.
* A Order deste WebSecurityConfigurerAdapter deve ser > 3, para que o configure(HttpSecurity http) do
* ResourceServerConfig tenha precedência sobre o configure(HttpSecurity http) do SecurityConfig.
*/
@Configuration
@EnableWebSecurity
@Order(4)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ROLE");
		// https://stackoverflow.com/questions/46999940/spring-boot-passwordencoder-error
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Bean //Tive que expor a UserDetailsService por causa do Spring Boot 2
//	@Override
//	public UserDetailsService userDetailsServiceBean() throws Exception {
//		return super.userDetailsServiceBean();
//	}
}
